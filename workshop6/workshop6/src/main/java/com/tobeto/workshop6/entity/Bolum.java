package com.tobeto.workshop6.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Bolum extends EntityBase{
  private String adi;
  @OneToMany(mappedBy = "bolum")
  private List<Personel>personels;
}
