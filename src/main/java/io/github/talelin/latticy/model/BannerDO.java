package io.github.talelin.latticy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BannerDO {

    private Long id;
    private String name;
    private String description;
    private String title;
    private String img;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;

}
