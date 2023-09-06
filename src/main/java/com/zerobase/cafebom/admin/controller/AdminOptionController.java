package com.zerobase.cafebom.admin.controller;

import com.zerobase.cafebom.option.dto.OptionForm;
import com.zerobase.cafebom.option.service.OptionService;
import com.zerobase.cafebom.option.dto.OptionDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "admin-option-controller", description = "관리자 옵션 CRUD API")
@Controller
@RequestMapping("/admin/option")
@RequiredArgsConstructor
//@PreAuthorize("hasRole('ADMIN')")
public class AdminOptionController {

    private final OptionService optionService;

    // jiyeon-23.09.05
    @ApiOperation(value = "옵션 등록", notes = "관리자가 옵션을 등록합니다.")
    @PostMapping
    public ResponseEntity<?> optionAdd(@RequestBody OptionForm.Request optionFormRequest) {
        optionService.addOption(OptionDto.Request.from(optionFormRequest));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // jiyeon-23.09.05
    @ApiOperation(value = "옵션 수정", notes = "관리자가 옵션의 정보를 수정합니다.")
    @PutMapping("/{optionId}")
    public ResponseEntity<?> optionModify(
        @PathVariable Integer optionId,
        @RequestBody OptionForm.Request form) {
        optionService.modifyOption(optionId, OptionDto.Request.from(form));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // jiyeon-23.09.05
    @ApiOperation(value = "옵션 삭제", notes = "관리자가 옵션을 삭제합니다.")
    @DeleteMapping("/{optionId}")
    public ResponseEntity<?> optionRemove(@PathVariable Integer optionId) {
        optionService.removeOption(optionId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // jiyeon-23.09.05
    @ApiOperation(value = "옵션 전체 조회", notes = "관리자가 전체 옵션 목록을 조회합니다.")
    @GetMapping("/list")
    public ResponseEntity<?> optionList() {
        List<OptionForm.Response> optionList = optionService.findAllOption();
        return ResponseEntity.ok().body(optionList);
    }

    // jiyeon-23.09.05
    @ApiOperation(value = "옵션 단건 조회", notes = "관리자가 하나의 옵션에 대한 정보를 조회합니다.")
    @GetMapping("/{optionId}")
    public ResponseEntity<?> optionListById(@PathVariable Integer optionId) {
        OptionForm.Response response = optionService.findByIdOption(optionId);
        return ResponseEntity.ok().body(response);
    }
}