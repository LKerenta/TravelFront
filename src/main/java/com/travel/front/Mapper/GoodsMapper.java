package com.travel.front.Mapper;

import com.travel.front.Entity.Goods;
import com.travel.front.Entity.ScenicSpot;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("SELECT * FROM goods where State!=-1")
    List<Goods> allGoods();

    @Select("SELECT * FROM goods where state=1")
    List<Goods> getAllGoods();
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID AND state=1")
    List<String> getAllFranName();

    @Select("SELECT * FROM goods where GoodsName=#{GoodName} AND state=1")
    List<Goods> getGoodsByGoodName(String GoodName);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsName=#{GoodName} AND state=1")
    List<String> getAllFranNameByGoodName(String GoodName);

    @Select("SELECT * FROM goods where GoodsID=#{GoodID} AND state=1")
    List<Goods> getAllGoodsByGoodID(Integer GoodID);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsID=#{GoodID} AND state=1")
    List<String> getAllFranNameByGoodID(Integer GoodID);

    @Select("SELECT * FROM goods where Price=#{Price} AND state=1")
    List<Goods> getAllGoodsByPrice(Integer Price);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and Price=#{Price} AND state=1")
    List<String> getAllFranNameByPrice(Integer Price);

    @Select("SELECT goods.* FROM goods JOIN franchise where franchise.FranID=goods.FranID and FranName=#{FranName} AND state=1")
    List<Goods> getAllGoodsByFranName(String FranName);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and FranName=#{FranName} AND state=1")
    List<String> getAllFranNameByFranName(String FranName);

    @Select("SELECT goods.* FROM goods JOIN franchise where franchise.FranID=goods.FranID and FranName=#{FranName} and GoodsName=#{GoodsName} AND state=1")
    List<Goods> getAllGoodsByFranNameAndGoodsName(String GoodsName,String FranName);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and FranName=#{FranName} and GoodsName=#{GoodsName} AND state=1")
    List<String> getAllFranNameByFranNameAndGoodsName(String GoodsName,String FranName);

    @Select("SELECT goods.* FROM goods JOIN franchise where franchise.FranID=goods.FranID and Price=#{Price} and GoodsName=#{GoodsName} AND state=1")
    List<Goods> getAllGoodsByPriceAndGoodsName(String GoodsName,Integer Price);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and Price=#{Price} and GoodsName=#{GoodsName} AND state=1")
    List<String> getAllFranNameByPriceAndGoodsName(String GoodsName,Integer Price);

    @Select("SELECT goods.* FROM goods JOIN franchise where franchise.FranID=goods.FranID and Price=#{Price} and FranName=#{FranName} AND state=1")
    List<Goods> getAllGoodsByPriceAndFranName(String FranName,Integer Price);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and Price=#{Price} and FranName=#{FranName} AND state=1")
    List<String> getAllFranNameByPriceAndFranName(String FranName,Integer Price);

    @Select("SELECT goods.* FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsID=#{GoodsID} and FranName=#{FranName} AND state=1")
    List<Goods> getAllGoodsByGoodsIDAndFranName(String FranName,Integer GoodsID);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsID=#{GoodsID} and FranName=#{FranName} AND state=1")
    List<String> getAllFranNameByGoodsIDAndFranName(String FranName,Integer GoodsID);

    @Select("SELECT goods.* FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsID=#{GoodsID} and GoodsName=#{GoodsName} AND state=1")
    List<Goods> getAllGoodsByGoodsIDAndGoodsName(String GoodsName,Integer GoodsID);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsID=#{GoodsID} and GoodsName=#{GoodsName} AND state=1")
    List<String> getAllFranNameByGoodsIDAndGoodsName(String GoodsName,Integer GoodsID);

    @Select("SELECT goods.* FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsID=#{GoodsID} and Price=#{Price} AND state=1")
    List<Goods> getAllGoodsByGoodsIDAndPrice(Integer Price,Integer GoodsID);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsID=#{GoodsID} and Price=#{Price} AND state=1")
    List<String> getAllFranNameByGoodsIDAndPrice(Integer Price,Integer GoodsID);

    @Select("SELECT goods.* FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsName=#{GoodsName} and FranName=#{FranName} and Price=#{Price} AND state=1")
    List<Goods> getAllGoodsByGoodsNameAndFranNameAndPrice(Integer Price,String GoodsName,String FranName);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsName=#{GoodsName} and FranName=#{FranName} and Price=#{Price} AND state=1")
    List<String> getAllFranNameByGoodsNameAndFranNameAndPrice(Integer Price,String GoodsName,String FranName);

    @Select("SELECT goods.* FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsID=#{GoodsID} and FranName=#{FranName} and Price=#{Price} AND state=1")
    List<Goods> getAllGoodsByGoodsIDAndFranNameAndPrice(Integer Price,Integer GoodsID,String FranName);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsID=#{GoodsID} and FranName=#{FranName} and Price=#{Price} AND state=1")
    List<String> getAllFranNameByGoodsIDAndFranNameAndPrice(Integer Price,Integer GoodsID,String FranName);

    @Select("SELECT goods.* FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsName=#{GoodsName} and FranName=#{FranName} and GoodsID=#{GoodsID} AND state=1")
    List<Goods> getAllGoodsByGoodsNameAndFranNameAndGoodsID(Integer GoodsID,String GoodsName,String FranName);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsName=#{GoodsName} and FranName=#{FranName} and GoodsID=#{GoodsID} AND state=1")
    List<String> getAllFranNameByGoodsNameAndFranNameAndGoodsID(Integer GoodsID,String GoodsName,String FranName);

    @Select("SELECT goods.* FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsName=#{GoodsName} and GoodsID=#{GoodsID} and Price=#{Price} AND state=1")
    List<Goods> getAllGoodsByGoodsNameAndGoodsIDAndPrice(Integer Price,String GoodsName,Integer GoodsID);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and GoodsName=#{GoodsName} and GoodsID=#{GoodsID} and Price=#{Price} AND state=1")
    List<String> getAllFranNameByGoodsNameAndGoodsIDAndPrice(Integer Price,String GoodsName,Integer GoodsID);

    @Select("SELECT goods.* FROM goods JOIN franchise where franchise.FranID=goods.FranID and FranName=#{FranName} and GoodsName=#{GoodsName} and GoodsID=#{GoodsID} and Price=#{Price} AND state=1")
    List<Goods> getAllGoodsByGoodsNameAndGoodsIDAndPriceAndFranName(String FranName,Integer Price,String GoodsName,Integer GoodsID);
    @Select("SELECT FranName FROM goods JOIN franchise where franchise.FranID=goods.FranID and FranName=#{FranName} and GoodsName=#{GoodsName} and GoodsID=#{GoodsID} and Price=#{Price} AND state=1")
    List<String> getAllFranNameByGoodsNameAndGoodsIDAndPriceAndFranName(String FranName,Integer Price,String GoodsName,Integer GoodsID);


    @Select("SELECT * from goods where state=0")
    List<Goods> getAllExamineGoods();
    @Select("SELECT FranName from goods JOIN franchise where franchise.FranID=goods.FranID AND state=0 ORDER BY GoodsID")
    List<String> getAllExamineFranName();

    @Select("SELECT goods.* from goods JOIN franchise WHERE state=0 AND goods.FranID=franchise.FranID AND FranName LIKE CONCAT('%',#{FranName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') ORDER BY GoodsID")
    List<Goods> getAllExamineGoodsWithOutGoodsIDAndPrice(String GoodsName,String FranName);
    @Select("SELECT FranName from goods JOIN franchise WHERE state=0 AND goods.FranID=franchise.FranID AND FranName LIKE CONCAT('%',#{FranName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') ORDER BY GoodsID")
    List<String> getAllExamineFranNameWithOutGoodsIDAndPrice(String GoodsName,String FranName);

    @Select("SELECT goods.* from goods JOIN franchise WHERE state=0 AND GoodsID=#{GoodsID} AND goods.FranID=franchise.FranID AND FranName LIKE CONCAT('%',#{FranName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') ORDER BY GoodsID")
    List<Goods> getAllExamineGoodsByGoodsID(String GoodsName,String FranName,Integer GoodsID);
    @Select("SELECT FranName from goods JOIN franchise WHERE state=0 AND GoodsID=#{GoodsID} AND goods.FranID=franchise.FranID AND FranName LIKE CONCAT('%',#{FranName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') ORDER BY GoodsID")
    List<String> getAllExamineFranNameByGoodsID(String GoodsName,String FranName,Integer GoodsID);

    @Select("SELECT goods.* from goods JOIN franchise WHERE state=0 AND Price=#{Price} AND goods.FranID=franchise.FranID AND FranName LIKE CONCAT('%',#{FranName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') ORDER BY GoodsID")
    List<Goods> getAllExamineGoodsByPrice(String GoodsName,String FranName,Integer Price);
    @Select("SELECT FranName from goods JOIN franchise WHERE state=0 AND Price=#{Price} AND goods.FranID=franchise.FranID AND FranName LIKE CONCAT('%',#{FranName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') ORDER BY GoodsID")
    List<String> getAllExamineFranNameByPrice(String GoodsName,String FranName,Integer Price);

    @Select("SELECT goods.* from goods JOIN franchise WHERE state=0 AND GoodsID=#{GoodsID} AND Price=#{Price} AND goods.FranID=franchise.FranID AND FranName LIKE CONCAT('%',#{FranName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') ORDER BY GoodsID")
    List<Goods> getAllExamineGoodsByPriceAndGoodsID(Integer GoodsID,String GoodsName,String FranName,Integer Price);
    @Select("SELECT FranName from goods JOIN franchise WHERE state=0 AND GoodsID=#{GoodsID}  AND Price=#{Price} AND goods.FranID=franchise.FranID AND FranName LIKE CONCAT('%',#{FranName},'%') AND GoodsName LIKE CONCAT('%',#{GoodsName},'%') ORDER BY GoodsID")
    List<String> getAllExamineFranNameByPriceAndGoodsID(Integer GoodsID,String GoodsName,String FranName,Integer Price);

    @Update("UPDATE goods SET State=-1 WHERE GoodsID=#{GoodsID}")
    Integer deleteGoodsByGoodsID(Integer GoodsID);

    @Update("UPDATE goods set State=1 WHERE GoodsID=#{GoodsID}")
    Integer passExamine(Integer GoodsID);

    @Update("UPDATE goods set State=-1 WHERE GoodsID=#{GoodsID}")
    Integer rejectExamine(Integer GoodsID);

    @Select("SELECT * FROM goods where GoodsID=#{GoodsID}")
    Goods getGoodsByID(Integer GoodsID);

    @Select("SELECT * FROM scenicspot WHERE SSID=#{SSID}")
    ScenicSpot getScenicByID(Integer SSID);

    @Select("SELECT FranName FROM franchise JOIN goods WHERE goods.FranID=franchise.FranID AND GoodsID=#{GoodsID}")
    String getFranName(Integer GoodsID);

    @Update("UPDATE goods SET GoodsName=#{GoodsName},Price=#{Price},Number=#{Number},LaunchDate=#{LaunchDate},Ways=#{Ways},Meals=#{Meals},IntroduceG=#{IntroduceG} WHERE GoodsID=#{GoodsID};")
    Integer updateGood(Goods goods);
    @Update("UPDATE scenicspot SET SSImage_1=#{SSImage_1},SSImage_2=#{SSImage_2},SSImage_3=#{SSImage_3},Introduce=#{Introduce} WHERE SSID=#{SSID};")
    Integer updateScenic(ScenicSpot scenicSpot);

    @Select("SELECT * from goods where state=-1")
    List<Goods> getAllNotPassGoods();

    @Select("select * from goods where SSID=#{SSID}")
    List<Goods> getGoodsBySSID(ScenicSpot scenicSpot);

    @Select("select * from goods where FranID=#{FranID}")
    List<Goods> getGoodsByFranID(int FranID);

    @Select("select * from goods where LaunchDate=#{LaunchDate}")
    List<Goods> getGoodsByDate(Date date);

    @Select("select * from goods where GoodsName like '#{name}'")
    List<Goods> getGoodsByName(String name);

    @Select("select * from goods where Meals=#{Meals}")
    List<Goods> getGoodsByMeals(int Meals);

    //    Insert
    @Insert("insert into goods (GoodsName,Price,SSID,Number,FranID,LaunchDate,Ways,Meals)" +
            "values(#{GoodsName},#{Price},#{SSID},#{Number},#{FranID},#{LaunchDate},#{Ways},#{Meals})")
    Integer CreateGoods(Goods goods);
    //    Update
    @Update("UPDATE goods SET GoodsName=#{GoodsName},Price=#{Price},SSID=#{SSID},Number=#{Number},LaunchDate=#{LaunchDate},Ways=#{Ways},Meals=#{Meals}")
    Integer updateGoods(Goods goods);

    //    Delete
    @Delete("delete from goods where GoodsID=#{ID}")
    Integer deleteGoods(Integer ID);
}
