package com.projet1.dao;

import java.util.List;

import com.projet1.entities.Village;

public interface IVillage {
    public int add(Village village);
    public List<Village> villages();
    public int delete(int id, Village village);
    public Village getVillageByName(String nomVillage);
    public Village get(int id);
}