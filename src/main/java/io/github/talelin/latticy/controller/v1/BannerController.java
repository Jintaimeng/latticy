package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.PageResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/v1/banner")
@Validated
public class BannerController {
    @Autowired
    private BannerService bannerService;
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
