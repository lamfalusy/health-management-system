package hu.lamsoft.hms.androidclient.restapi.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import lombok.Data;

/**
 * Created by admin on 2017. 04. 14..
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Page<T> {

    private List<T> content;
    private Boolean last;
    private Boolean first;
    private Integer totalPages;
    private Integer totalElements;
    private Integer numberOfElements;
    private Integer size;
    private Integer number;

}
