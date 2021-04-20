package com.justas.lescinskas.Esports.mybatis.dao;

import com.justas.lescinskas.Esports.mybatis.model.Player;
import java.util.List;

public interface PlayerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Tue Apr 20 18:38:57 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Tue Apr 20 18:38:57 EEST 2021
     */
    int insert(Player record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Tue Apr 20 18:38:57 EEST 2021
     */
    Player selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Tue Apr 20 18:38:57 EEST 2021
     */
    List<Player> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Tue Apr 20 18:38:57 EEST 2021
     */
    int updateByPrimaryKey(Player record);
}