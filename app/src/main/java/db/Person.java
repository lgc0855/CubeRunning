package db;

import java.security.PrivateKey;

/**
 * Created by liguochao on 2016/5/21.
 * 在这个类中存储和读取个人信息
 */
public class Person {
    private static final String TABLE_NAME = "person" ;
    private static final String NAME = "UserName" ;
    private static final String SMALLNAME = "SmallName" ;//昵称
    private static final String PHOTO = "Photo" ;
    private static final String SEX = "Sex" ;
    private static final String AGE = "Age" ;
    private static final String WEIGTH = "Weight" ;
    private static final String HEIGHT = "Height" ;
    private static final String TRL = "TRL" ; // 跑步总里程
    private static final String TBL = "TBL" ;//骑行总里程
    private static final String NAME_TYPE = "TEXT" ;
    private static final String WEIGHT_TYPE = "INT" ;
    private static final String HEIGHT_TYPE = "INT" ;


    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + NAME
            + " nchar(50)" + "PRIMARY KEY ," + SMALLNAME +" nchar(50)," + PHOTO+" nchar(50),"
            +SEX+" nchar(50),"+ AGE +" INT," + WEIGTH + " INT," + HEIGHT + " INT,"+ TRL + " DOUBLE,"
            + TBL + " DOUBLE " + ")" ;

    public static String getCreateTable() {
        return CREATE_TABLE;
    }

    public static String getHEIGHT() {
        return HEIGHT;
    }

    public static String getNAME() {
        return NAME;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getWEIGTH() {
        return WEIGTH;
    }
    public static String getAGE() {
        return AGE;
    }

    public static String getHeightType() {
        return HEIGHT_TYPE;
    }

    public static String getNameType() {
        return NAME_TYPE;
    }

    public static String getPHOTO() {
        return PHOTO;
    }

    public static String getSEX() {
        return SEX;
    }

    public static String getSMALLNAME() {
        return SMALLNAME;
    }

    public static String getTBL() {
        return TBL;
    }

    public static String getTRL() {
        return TRL;
    }


}
