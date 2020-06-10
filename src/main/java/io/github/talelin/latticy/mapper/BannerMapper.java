package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.BannerDO;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BannerMapper {
    List<BannerDO> getAllBanners();
    long insertBanner(BannerDO bannerDO);
}
