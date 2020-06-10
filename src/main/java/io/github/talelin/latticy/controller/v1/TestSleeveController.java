package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.TestSleeveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/test")
public class TestSleeveController {
    @Autowired
    private TestSleeveService testSleeveService;
    @GetMapping("/test1")
    public List<BannerDO> test1(){
        return this.testSleeveService.getBanners();
    }

    @GetMapping("/test2")
    public long test2(){
        return this.testSleeveService.insertBanner();
    }
}
