package com.travel.front.Mapper;

import com.travel.front.Entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {
    @Select("SELECT * FROM manager WHERE MaID=#{MaID}")
    Manager findManagerByID(Integer MaID);

    @Update("UPDATE manager SET MaName=#{MaName},MaImage=#{MaImage},`Password`=#{Password},Phone=#{Phone},Email=#{Email} where MaID=#{MaID};")
    Integer updateManager(Manager manager);
}
