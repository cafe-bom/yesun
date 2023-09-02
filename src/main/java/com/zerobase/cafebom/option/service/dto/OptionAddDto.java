package com.zerobase.cafebom.option.service.dto;

import com.zerobase.cafebom.option.controller.form.OptionAddForm;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OptionAddDto {

    private Integer id;

    private Integer optionCategoryId;

    private String name;

    private Integer price;

    public static OptionAddDto from(OptionAddForm optionAddForm) {
        return OptionAddDto.builder()
                .optionCategoryId(optionAddForm.getOptionCategoryId())
                .name(optionAddForm.getName())
                .price(optionAddForm.getPrice())
                .build();
    }
}