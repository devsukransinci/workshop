package com.tobeto.workshop5.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class YonetmenDto {
    private String ad;
    private List<FilmDTO> filmler = new ArrayList<FilmDTO>();
}
