package com.project.movie.dto;

import com.project.movie.entity.FeePolicy;
import com.project.movie.entity.FeePolicyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.lang.Nullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeePolicyForm {
    private FeePolicyStatus feePolicyStatus;

    @Nullable
    @Range(min=0, max=100, message = "0 ~ 100% 할인율만 적용가능합니다.")
    private Integer regular_percent;

    @Nullable
    @Range(min=0, max=5000, message = "5000원 이하의 할인액만 적용가능합니다.")
    private Integer flatRate;

}
