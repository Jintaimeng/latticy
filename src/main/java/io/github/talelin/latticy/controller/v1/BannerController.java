package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.autoconfigure.response.Updated;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/banner")
@Validated
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @PutMapping("/{id}")//Putmapping表明更新操作
    public UpdatedVO update(@RequestBody @Validated BannerDTO bannerDTO,
                                       @PathVariable @Positive Long id){
        this.bannerService.update(bannerDTO,id);
        return new UpdatedVO();
    }

    @GetMapping("/page")
    public PageResponseVO<BannerDO> getBanners(@RequestParam(required = false, defaultValue = "0")
                           @Min(value = 0) Integer page,
                           @RequestParam(required = false, defaultValue = "10")
                           @Min(value = 1)
                           @Max(value = 20) Integer count){
        Page<BannerDO> pager = new Page<>(page, count);
        IPage<BannerDO> paging = this.bannerService.getBaseMapper().selectPage(pager, null);
        return new PageResponseVO<BannerDO> (paging.getTotal(), paging.getRecords(), paging.getCurrent(), paging.getSize());
    }
}
