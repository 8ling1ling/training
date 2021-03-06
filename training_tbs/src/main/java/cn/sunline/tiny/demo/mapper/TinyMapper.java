package cn.sunline.tiny.demo.mapper;

import cn.sunline.tiny.core.Constant;
import cn.sunline.tiny.util.FileUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * mapper Auxiliary class, ide dynamic generation
 */
public class TinyMapper {

	public static SqlSessionFactory getSqlSessionFactoryBean(DataSource dataSource){
		SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
		try {
			sqlSessionFactoryBean.setDataSource(dataSource);
	        // 设置别名包（实体类）
	        sqlSessionFactoryBean.setTypeAliasesPackage("cn.sunline.tiny.demo.entity");
			String path = Constant.getWebPath()+File.separator+"mapper";
	        File mapperFold = new File(path);
	        if(!mapperFold.exists()) {
	        	return null;
	        }
			List<Resource> rs = new ArrayList<Resource>();
	        for(File file : mapperFold.listFiles()) {
	        	String name = file.getName();
	        	if(name.endsWith("xml")) {
	        		String xml = FileUtil.read(file);
	        		
	        		try {
	        			 Method getMapper = TinyMapper.class.getMethod("get"+name.substring(0,name.length()-4));
		        		 String s = (String) getMapper.invoke(null,null);
		        		 //System.out.println(s);
		        		 xml = xml.replace("</mapper>", s)+"</mapper>";
		        		 
	        		}catch(Exception ex) {
	        			
	        			//System.out.println(name+"Can not identify Mapper");
	        			 
	        		}
					ByteArrayResource bs = new ByteArrayResource(xml.getBytes("utf-8"),file.getPath());
	        		rs.add(bs);
	        	}
	        }
	        Resource[] rss = new Resource[rs.size()];
	        for(int i=0;i<rs.size();i++) {
	        	rss[i] = rs.get(i);
	        }
	      
	        //设置sql配置文件路径
	        sqlSessionFactoryBean.setMapperLocations(rss);
	        //-- 加载mybatis的全局配置文件  
	        Resource mybatisConfigXml = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
	        sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);			return sqlSessionFactoryBean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	public static String getProductIncomeMapper() {

return	"<resultMap id=\"BaseResultMap\" type=\"cn.sunline.tiny.demo.entity.ProductIncome\">"
		+"	<id column=\"id\" jdbcType=\"INTEGER\" property=\"id\" />"
		+"	<result column=\"uid\" jdbcType=\"INTEGER\" property=\"uid\" />"
		+"	<result column=\"product_id\" jdbcType=\"INTEGER\" property=\"productId\" />"
		+"	<result column=\"buy_num\" jdbcType=\"DECIMAL\" property=\"buyNum\" />"
		+"	<result column=\"income_date\" jdbcType=\"TIMESTAMP\" property=\"incomeDate\" />"
		+"	<result column=\"income_money\" jdbcType=\"DECIMAL\" property=\"incomeMoney\" />"
		+"	<result column=\"time1\" jdbcType=\"TIMESTAMP\" property=\"time1\" />"
		+"	<result column=\"state\" jdbcType=\"CHAR\" property=\"state\" />"
	+"	</resultMap>"
	+"	<sql id=\"Base_Column_List\">"
		+"id,uid,product_id,buy_num,income_date,income_money,time,state"
	+"	</sql>"
	+"	<select id=\"selectById\" parameterType=\"Integer\" resultMap=\"BaseResultMap\">"
		+"	select "
		+"	<include refid=\"Base_Column_List\" />"
		+"	from product_income"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</select>"
	+"	<delete id=\"deleteById\" parameterType=\"Integer\">"
		+"	delete from product_income"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</delete>"
	+"	<insert id=\"insert\" keyColumn=\"id\" keyProperty=\"id\" parameterType=\"cn.sunline.tiny.demo.entity.ProductIncome\" useGeneratedKeys=\"true\">"
		+"	insert into product_income"
		+"	<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"
			+"<if test=\"id != null\">"
				+"id,"
			+"</if>"
			+"<if test=\"uid != null\">"
				+"uid,"
			+"</if>"
			+"<if test=\"productId != null\">"
				+"product_id,"
			+"</if>"
			+"<if test=\"buyNum != null\">"
				+"buy_num,"
			+"</if>"
			+"<if test=\"incomeDate != null\">"
				+"income_date,"
			+"</if>"
			+"<if test=\"incomeMoney != null\">"
				+"income_money,"
			+"</if>"
			+"<if test=\"time != null\">"
				+"time,"
			+"</if>"
		+"	</trim>"
		+"	<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"
			+"<if test=\"id != null\">"
				+"#{id,jdbcType=INTEGER},"
			+"</if>"
			+"<if test=\"uid != null\">"
				+"#{uid,jdbcType=INTEGER},"
			+"</if>"
			+"<if test=\"productId != null\">"
				+"#{productId,jdbcType=INTEGER},"
			+"</if>"
			+"<if test=\"buyNum != null\">"
				+"#{buyNum,jdbcType=DECIMAL},"
			+"</if>"
			+"<if test=\"incomeDate != null\">"
				+"#{incomeDate,jdbcType=TIME},"
			+"</if>"
			+"<if test=\"incomeMoney != null\">"
				+"#{incomeMoney,jdbcType=DECIMAL},"
			+"</if>"
			+"<if test=\"time != null\">"
				+"#{time,jdbcType=TIME},"
			+"</if>"
		+"	</trim>"
	+"	</insert>"
	+"	<update id=\"updateById\" parameterType=\"cn.sunline.tiny.demo.entity.ProductIncome\">"
		+"	update product_income"
		+"	<set>"
		+"	<if test=\"uid != null\">"
			+"uid = #{uid,jdbcType=INTEGER},"
		+"	</if>"
		+"	<if test=\"productId != null\">"
			+"product_id = #{productId,jdbcType=INTEGER},"
		+"	</if>"
		+"	<if test=\"buyNum != null\">"
			+"buy_num = #{buyNum,jdbcType=DECIMAL},"
		+"	</if>"
		+"	<if test=\"incomeDate != null\">"
			+"income_date = #{incomeDate,jdbcType=TIME},"
		+"	</if>"
		+"	<if test=\"incomeMoney != null\">"
			+"income_money = #{incomeMoney,jdbcType=DECIMAL},"
		+"	</if>"
		+"	<if test=\"time != null\">"
			+"time = #{time,jdbcType=TIME},"
		+"	</if>"
		+"	</set>"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</update>";
	}
	public static String getProductInformationMapper() {

return	"<resultMap id=\"BaseResultMap\" type=\"cn.sunline.tiny.demo.entity.ProductInformation\">"
		+"	<id column=\"id\" jdbcType=\"INTEGER\" property=\"id\" />"
		+"	<result column=\"product_name\" jdbcType=\"VARCHAR\" property=\"productName\" />"
		+"	<result column=\"product_rate\" jdbcType=\"DOUBLE\" property=\"productRate\" />"
		+"	<result column=\"information\" jdbcType=\"VARCHAR\" property=\"information\" />"
		+"	<result column=\"product_cycle\" jdbcType=\"INTEGER\" property=\"productCycle\" />"
		+"	<result column=\"product_begin\" jdbcType=\"TIME\" property=\"productBegin\" />"
		+"	<result column=\"product_all\" jdbcType=\"DECIMAL\" property=\"productAll\" />"
		+"	<result column=\"left_product_money\" jdbcType=\"DECIMAL\" property=\"leftProductMoney\" />"
		+"	<result column=\"min_buy\" jdbcType=\"DECIMAL\" property=\"minBuy\" />"
		+"	<result column=\"max_buy\" jdbcType=\"DECIMAL\" property=\"maxBuy\" />"
		+"	<result column=\"product_boolean_null\" jdbcType=\"TINYINT\" property=\"productBooleanNull\" />"
		+"	<result column=\"product_null_time\" jdbcType=\"TIME\" property=\"productNullTime\" />"
		+"	<result column=\"time\" jdbcType=\"TIME\" property=\"time\" />"
	+"	</resultMap>"
	+"	<sql id=\"Base_Column_List\">"
		+"id,product_name,product_rate,information,product_cycle,product_begin,product_all,left_product_money,min_buy,max_buy,product_boolean_null,product_null_time,time"
	+"	</sql>"
	+"	<select id=\"selectById\" parameterType=\"Integer\" resultMap=\"BaseResultMap\">"
		+"	select "
		+"	<include refid=\"Base_Column_List\" />"
		+"	from product_information"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</select>"
	+"	<delete id=\"deleteById\" parameterType=\"Integer\">"
		+"	delete from product_information"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</delete>"
	+"	<insert id=\"insert\" keyColumn=\"id\" keyProperty=\"id\" parameterType=\"cn.sunline.tiny.demo.entity.ProductInformation\" useGeneratedKeys=\"true\">"
		+"	insert into product_information"
		+"	<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"
			+"<if test=\"id != null\">"
				+"id,"
			+"</if>"
			+"<if test=\"productName != null\">"
				+"product_name,"
			+"</if>"
			+"<if test=\"productRate != null\">"
				+"product_rate,"
			+"</if>"
			+"<if test=\"information != null\">"
				+"information,"
			+"</if>"
			+"<if test=\"productCycle != null\">"
				+"product_cycle,"
			+"</if>"
			+"<if test=\"productBegin != null\">"
				+"product_begin,"
			+"</if>"
			+"<if test=\"productAll != null\">"
				+"product_all,"
			+"</if>"
			+"<if test=\"leftProductMoney != null\">"
				+"left_product_money,"
			+"</if>"
			+"<if test=\"minBuy != null\">"
				+"min_buy,"
			+"</if>"
			+"<if test=\"maxBuy != null\">"
				+"max_buy,"
			+"</if>"
			+"<if test=\"productBooleanNull != null\">"
				+"product_boolean_null,"
			+"</if>"
			+"<if test=\"productNullTime != null\">"
				+"product_null_time,"
			+"</if>"
			+"<if test=\"time != null\">"
				+"time,"
			+"</if>"
		+"	</trim>"
		+"	<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"
			+"<if test=\"id != null\">"
				+"#{id,jdbcType=INTEGER},"
			+"</if>"
			+"<if test=\"productName != null\">"
				+"#{productName,jdbcType=VARCHAR},"
			+"</if>"
			+"<if test=\"productRate != null\">"
				+"#{productRate,jdbcType=DOUBLE},"
			+"</if>"
			+"<if test=\"information != null\">"
				+"#{information,jdbcType=VARCHAR},"
			+"</if>"
			+"<if test=\"productCycle != null\">"
				+"#{productCycle,jdbcType=INTEGER},"
			+"</if>"
			+"<if test=\"productBegin != null\">"
				+"#{productBegin,jdbcType=TIME},"
			+"</if>"
			+"<if test=\"productAll != null\">"
				+"#{productAll,jdbcType=DECIMAL},"
			+"</if>"
			+"<if test=\"leftProductMoney != null\">"
				+"#{leftProductMoney,jdbcType=DECIMAL},"
			+"</if>"
			+"<if test=\"minBuy != null\">"
				+"#{minBuy,jdbcType=DECIMAL},"
			+"</if>"
			+"<if test=\"maxBuy != null\">"
				+"#{maxBuy,jdbcType=DECIMAL},"
			+"</if>"
			+"<if test=\"productBooleanNull != null\">"
				+"#{productBooleanNull,jdbcType=TINYINT},"
			+"</if>"
			+"<if test=\"productNullTime != null\">"
				+"#{productNullTime,jdbcType=TIME},"
			+"</if>"
			+"<if test=\"time != null\">"
				+"#{time,jdbcType=TIME},"
			+"</if>"
		+"	</trim>"
	+"	</insert>"
	+"	<update id=\"updateById\" parameterType=\"cn.sunline.tiny.demo.entity.ProductInformation\">"
		+"	update product_information"
		+"	<set>"
		+"	<if test=\"productName != null\">"
			+"product_name = #{productName,jdbcType=VARCHAR},"
		+"	</if>"
		+"	<if test=\"productRate != null\">"
			+"product_rate = #{productRate,jdbcType=DOUBLE},"
		+"	</if>"
		+"	<if test=\"information != null\">"
			+"information = #{information,jdbcType=VARCHAR},"
		+"	</if>"
		+"	<if test=\"productCycle != null\">"
			+"product_cycle = #{productCycle,jdbcType=INTEGER},"
		+"	</if>"
		+"	<if test=\"productBegin != null\">"
			+"product_begin = #{productBegin,jdbcType=TIME},"
		+"	</if>"
		+"	<if test=\"productAll != null\">"
			+"product_all = #{productAll,jdbcType=DECIMAL},"
		+"	</if>"
		+"	<if test=\"leftProductMoney != null\">"
			+"left_product_money = #{leftProductMoney,jdbcType=DECIMAL},"
		+"	</if>"
		+"	<if test=\"minBuy != null\">"
			+"min_buy = #{minBuy,jdbcType=DECIMAL},"
		+"	</if>"
		+"	<if test=\"maxBuy != null\">"
			+"max_buy = #{maxBuy,jdbcType=DECIMAL},"
		+"	</if>"
		+"	<if test=\"productBooleanNull != null\">"
			+"product_boolean_null = #{productBooleanNull,jdbcType=TINYINT},"
		+"	</if>"
		+"	<if test=\"productNullTime != null\">"
			+"product_null_time = #{productNullTime,jdbcType=TIME},"
		+"	</if>"
		+"	<if test=\"time != null\">"
			+"time = #{time,jdbcType=TIME},"
		+"	</if>"
		+"	</set>"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</update>";
	}
	public static String getStoredRecordMapper() {

return	"<resultMap id=\"BaseResultMap\" type=\"cn.sunline.tiny.demo.entity.StoredRecord\">"
		+"	<id column=\"id\" jdbcType=\"INTEGER\" property=\"id\" />"
		+"	<result column=\"u_id\" jdbcType=\"TINYINT\" property=\"uId\" />"
		+"	<result column=\"store_money\" jdbcType=\"DECIMAL\" property=\"storeMoney\" />"
		+"	<result column=\"store_time\" jdbcType=\"TIME\" property=\"storeTime\" />"
		+"	<result column=\"time\" jdbcType=\"TIME\" property=\"time\" />"
	+"	</resultMap>"
	+"	<sql id=\"Base_Column_List\">"
		+"id,u_id,store_money,store_time,time"
	+"	</sql>"
	+"	<select id=\"selectById\" parameterType=\"Integer\" resultMap=\"BaseResultMap\">"
		+"	select "
		+"	<include refid=\"Base_Column_List\" />"
		+"	from stored_record"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</select>"
	+"	<delete id=\"deleteById\" parameterType=\"Integer\">"
		+"	delete from stored_record"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</delete>"
	+"	<insert id=\"insert\" keyColumn=\"id\" keyProperty=\"id\" parameterType=\"cn.sunline.tiny.demo.entity.StoredRecord\" useGeneratedKeys=\"true\">"
		+"	insert into stored_record"
		+"	<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"
			+"<if test=\"id != null\">"
				+"id,"
			+"</if>"
			+"<if test=\"uId != null\">"
				+"u_id,"
			+"</if>"
			+"<if test=\"storeMoney != null\">"
				+"store_money,"
			+"</if>"
			+"<if test=\"storeTime != null\">"
				+"store_time,"
			+"</if>"
			+"<if test=\"time != null\">"
				+"time,"
			+"</if>"
		+"	</trim>"
		+"	<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"
			+"<if test=\"id != null\">"
				+"#{id,jdbcType=INTEGER},"
			+"</if>"
			+"<if test=\"uId != null\">"
				+"#{uId,jdbcType=TINYINT},"
			+"</if>"
			+"<if test=\"storeMoney != null\">"
				+"#{storeMoney,jdbcType=DECIMAL},"
			+"</if>"
			+"<if test=\"storeTime != null\">"
				+"#{storeTime,jdbcType=TIME},"
			+"</if>"
			+"<if test=\"time != null\">"
				+"#{time,jdbcType=TIME},"
			+"</if>"
		+"	</trim>"
	+"	</insert>"
	+"	<update id=\"updateById\" parameterType=\"cn.sunline.tiny.demo.entity.StoredRecord\">"
		+"	update stored_record"
		+"	<set>"
		+"	<if test=\"uId != null\">"
			+"u_id = #{uId,jdbcType=TINYINT},"
		+"	</if>"
		+"	<if test=\"storeMoney != null\">"
			+"store_money = #{storeMoney,jdbcType=DECIMAL},"
		+"	</if>"
		+"	<if test=\"storeTime != null\">"
			+"store_time = #{storeTime,jdbcType=TIME},"
		+"	</if>"
		+"	<if test=\"time != null\">"
			+"time = #{time,jdbcType=TIME},"
		+"	</if>"
		+"	</set>"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</update>";
	}
	public static String getTbsAccountMapper() {

return	"<resultMap id=\"BaseResultMap\" type=\"cn.sunline.tiny.demo.entity.TbsAccount\">"
		+"	<id column=\"id\" jdbcType=\"INTEGER\" property=\"id\" />"
		+"	<result column=\"u_id\" jdbcType=\"TINYINT\" property=\"uId\" />"
		+"	<result column=\"account_balance\" jdbcType=\"DECIMAL\" property=\"accountBalance\" />"
		+"	<result column=\"time\" jdbcType=\"TIME\" property=\"time\" />"
	+"	</resultMap>"
	+"	<sql id=\"Base_Column_List\">"
		+"id,u_id,account_balance,time"
	+"	</sql>"
	+"	<select id=\"selectById\" parameterType=\"Integer\" resultMap=\"BaseResultMap\">"
		+"	select "
		+"	<include refid=\"Base_Column_List\" />"
		+"	from tbs_account"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</select>"
	+"	<delete id=\"deleteById\" parameterType=\"Integer\">"
		+"	delete from tbs_account"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</delete>"
	+"	<insert id=\"insert\" keyColumn=\"id\" keyProperty=\"id\" parameterType=\"cn.sunline.tiny.demo.entity.TbsAccount\" useGeneratedKeys=\"true\">"
		+"	insert into tbs_account"
		+"	<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"
			+"<if test=\"id != null\">"
				+"id,"
			+"</if>"
			+"<if test=\"uId != null\">"
				+"u_id,"
			+"</if>"
			+"<if test=\"accountBalance != null\">"
				+"account_balance,"
			+"</if>"
			+"<if test=\"time != null\">"
				+"time,"
			+"</if>"
		+"	</trim>"
		+"	<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"
			+"<if test=\"id != null\">"
				+"#{id,jdbcType=INTEGER},"
			+"</if>"
			+"<if test=\"uId != null\">"
				+"#{uId,jdbcType=TINYINT},"
			+"</if>"
			+"<if test=\"accountBalance != null\">"
				+"#{accountBalance,jdbcType=DECIMAL},"
			+"</if>"
			+"<if test=\"time != null\">"
				+"#{time,jdbcType=TIME},"
			+"</if>"
		+"	</trim>"
	+"	</insert>"
	+"	<update id=\"updateById\" parameterType=\"cn.sunline.tiny.demo.entity.TbsAccount\">"
		+"	update tbs_account"
		+"	<set>"
		+"	<if test=\"uId != null\">"
			+"u_id = #{uId,jdbcType=TINYINT},"
		+"	</if>"
		+"	<if test=\"accountBalance != null\">"
			+"account_balance = #{accountBalance,jdbcType=DECIMAL},"
		+"	</if>"
		+"	<if test=\"time != null\">"
			+"time = #{time,jdbcType=TIME},"
		+"	</if>"
		+"	</set>"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</update>";
	}
	public static String getTbsExpendMapper() {

return	"<resultMap id=\"BaseResultMap\" type=\"cn.sunline.tiny.demo.entity.TbsExpend\">"
		+"	<id column=\"id\" jdbcType=\"INTEGER\" property=\"id\" />"
		+"	<result column=\"u_id\" jdbcType=\"TINYINT\" property=\"uId\" />"
		+"	<result column=\"take_record\" jdbcType=\"DECIMAL\" property=\"takeRecord\" />"
		+"	<result column=\"take_time\" jdbcType=\"TIME\" property=\"takeTime\" />"
		+"	<result column=\"time\" jdbcType=\"TIME\" property=\"time\" />"
	+"	</resultMap>"
	+"	<sql id=\"Base_Column_List\">"
		+"id,u_id,take_record,take_time,time"
	+"	</sql>"
	+"	<select id=\"selectById\" parameterType=\"Integer\" resultMap=\"BaseResultMap\">"
		+"	select "
		+"	<include refid=\"Base_Column_List\" />"
		+"	from tbs_expend"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</select>"
	+"	<delete id=\"deleteById\" parameterType=\"Integer\">"
		+"	delete from tbs_expend"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</delete>"
	+"	<insert id=\"insert\" keyColumn=\"id\" keyProperty=\"id\" parameterType=\"cn.sunline.tiny.demo.entity.TbsExpend\" useGeneratedKeys=\"true\">"
		+"	insert into tbs_expend"
		+"	<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"
			+"<if test=\"id != null\">"
				+"id,"
			+"</if>"
			+"<if test=\"uId != null\">"
				+"u_id,"
			+"</if>"
			+"<if test=\"takeRecord != null\">"
				+"take_record,"
			+"</if>"
			+"<if test=\"takeTime != null\">"
				+"take_time,"
			+"</if>"
			+"<if test=\"time != null\">"
				+"time,"
			+"</if>"
		+"	</trim>"
		+"	<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"
			+"<if test=\"id != null\">"
				+"#{id,jdbcType=INTEGER},"
			+"</if>"
			+"<if test=\"uId != null\">"
				+"#{uId,jdbcType=TINYINT},"
			+"</if>"
			+"<if test=\"takeRecord != null\">"
				+"#{takeRecord,jdbcType=DECIMAL},"
			+"</if>"
			+"<if test=\"takeTime != null\">"
				+"#{takeTime,jdbcType=TIME},"
			+"</if>"
			+"<if test=\"time != null\">"
				+"#{time,jdbcType=TIME},"
			+"</if>"
		+"	</trim>"
	+"	</insert>"
	+"	<update id=\"updateById\" parameterType=\"cn.sunline.tiny.demo.entity.TbsExpend\">"
		+"	update tbs_expend"
		+"	<set>"
		+"	<if test=\"uId != null\">"
			+"u_id = #{uId,jdbcType=TINYINT},"
		+"	</if>"
		+"	<if test=\"takeRecord != null\">"
			+"take_record = #{takeRecord,jdbcType=DECIMAL},"
		+"	</if>"
		+"	<if test=\"takeTime != null\">"
			+"take_time = #{takeTime,jdbcType=TIME},"
		+"	</if>"
		+"	<if test=\"time != null\">"
			+"time = #{time,jdbcType=TIME},"
		+"	</if>"
		+"	</set>"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</update>";
	}
	public static String getTbsUserMapper() {

return	"<resultMap id=\"BaseResultMap\" type=\"cn.sunline.tiny.demo.entity.TbsUser\">"
		+"	<id column=\"id\" jdbcType=\"INTEGER\" property=\"id\" />"
		+"	<result column=\"u_name\" jdbcType=\"VARCHAR\" property=\"uName\" />"
		+"	<result column=\"u_phone\" jdbcType=\"CHAR\" property=\"uPhone\" />"
		+"	<result column=\"login_password\" jdbcType=\"CHAR\" property=\"loginPassword\" />"
		+"	<result column=\"id_identity\" jdbcType=\"INTEGER\" property=\"idIdentity\" />"
		+"	<result column=\"registration_date\" jdbcType=\"TIME\" property=\"registrationDate\" />"
		+"	<result column=\"car_number\" jdbcType=\"INTEGER\" property=\"carNumber\" />"
		+"	<result column=\"login_date\" jdbcType=\"TIME\" property=\"loginDate\" />"
		+"	<result column=\"head_img\" jdbcType=\"VARCHAR\" property=\"headImg\" />"
		+"	<result column=\"time\" jdbcType=\"TIME\" property=\"time\" />"
		+"	<result column=\"user_state\" jdbcType=\"TINYINT\" property=\"userState\" />"
	+"	</resultMap>"
	+"	<sql id=\"Base_Column_List\">"
		+"id,u_name,u_phone,login_password,id_identity,registration_date,car_number,login_date,head_img,time,user_state"
	+"	</sql>"
	+"	<select id=\"selectById\" parameterType=\"Integer\" resultMap=\"BaseResultMap\">"
		+"	select "
		+"	<include refid=\"Base_Column_List\" />"
		+"	from tbs_user"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</select>"
	+"	<delete id=\"deleteById\" parameterType=\"Integer\">"
		+"	delete from tbs_user"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</delete>"
	+"	<insert id=\"insert\" keyColumn=\"id\" keyProperty=\"id\" parameterType=\"cn.sunline.tiny.demo.entity.TbsUser\" useGeneratedKeys=\"true\">"
		+"	insert into tbs_user"
		+"	<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"
			+"<if test=\"id != null\">"
				+"id,"
			+"</if>"
			+"<if test=\"uName != null\">"
				+"u_name,"
			+"</if>"
			+"<if test=\"uPhone != null\">"
				+"u_phone,"
			+"</if>"
			+"<if test=\"loginPassword != null\">"
				+"login_password,"
			+"</if>"
			+"<if test=\"idIdentity != null\">"
				+"id_identity,"
			+"</if>"
			+"<if test=\"registrationDate != null\">"
				+"registration_date,"
			+"</if>"
			+"<if test=\"carNumber != null\">"
				+"car_number,"
			+"</if>"
			+"<if test=\"loginDate != null\">"
				+"login_date,"
			+"</if>"
			+"<if test=\"headImg != null\">"
				+"head_img,"
			+"</if>"
			+"<if test=\"time != null\">"
				+"time,"
			+"</if>"
			+"<if test=\"userState != null\">"
				+"user_state,"
			+"</if>"
		+"	</trim>"
		+"	<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"
			+"<if test=\"id != null\">"
				+"#{id,jdbcType=INTEGER},"
			+"</if>"
			+"<if test=\"uName != null\">"
				+"#{uName,jdbcType=VARCHAR},"
			+"</if>"
			+"<if test=\"uPhone != null\">"
				+"#{uPhone,jdbcType=CHAR},"
			+"</if>"
			+"<if test=\"loginPassword != null\">"
				+"#{loginPassword,jdbcType=CHAR},"
			+"</if>"
			+"<if test=\"idIdentity != null\">"
				+"#{idIdentity,jdbcType=INTEGER},"
			+"</if>"
			+"<if test=\"registrationDate != null\">"
				+"#{registrationDate,jdbcType=TIME},"
			+"</if>"
			+"<if test=\"carNumber != null\">"
				+"#{carNumber,jdbcType=INTEGER},"
			+"</if>"
			+"<if test=\"loginDate != null\">"
				+"#{loginDate,jdbcType=TIME},"
			+"</if>"
			+"<if test=\"headImg != null\">"
				+"#{headImg,jdbcType=VARCHAR},"
			+"</if>"
			+"<if test=\"time != null\">"
				+"#{time,jdbcType=TIME},"
			+"</if>"
			+"<if test=\"userState != null\">"
				+"#{userState,jdbcType=TINYINT},"
			+"</if>"
		+"	</trim>"
	+"	</insert>"
	+"	<update id=\"updateById\" parameterType=\"cn.sunline.tiny.demo.entity.TbsUser\">"
		+"	update tbs_user"
		+"	<set>"
		+"	<if test=\"uName != null\">"
			+"u_name = #{uName,jdbcType=VARCHAR},"
		+"	</if>"
		+"	<if test=\"uPhone != null\">"
			+"u_phone = #{uPhone,jdbcType=CHAR},"
		+"	</if>"
		+"	<if test=\"loginPassword != null\">"
			+"login_password = #{loginPassword,jdbcType=CHAR},"
		+"	</if>"
		+"	<if test=\"idIdentity != null\">"
			+"id_identity = #{idIdentity,jdbcType=INTEGER},"
		+"	</if>"
		+"	<if test=\"registrationDate != null\">"
			+"registration_date = #{registrationDate,jdbcType=TIME},"
		+"	</if>"
		+"	<if test=\"carNumber != null\">"
			+"car_number = #{carNumber,jdbcType=INTEGER},"
		+"	</if>"
		+"	<if test=\"loginDate != null\">"
			+"login_date = #{loginDate,jdbcType=TIME},"
		+"	</if>"
		+"	<if test=\"headImg != null\">"
			+"head_img = #{headImg,jdbcType=VARCHAR},"
		+"	</if>"
		+"	<if test=\"time != null\">"
			+"time = #{time,jdbcType=TIME},"
		+"	</if>"
		+"	<if test=\"userState != null\">"
			+"user_state = #{userState,jdbcType=TINYINT},"
		+"	</if>"
		+"	</set>"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</update>";
	}
	public static String getTbsVersionMapper() {

return	"<resultMap id=\"BaseResultMap\" type=\"cn.sunline.tiny.demo.entity.TbsVersion\">"
		+"	<id column=\"id\" jdbcType=\"INTEGER\" property=\"id\" />"
		+"	<result column=\"version\" jdbcType=\"VARCHAR\" property=\"version\" />"
		+"	<result column=\"type\" jdbcType=\"INTEGER\" property=\"type\" />"
	+"	</resultMap>"
	+"	<sql id=\"Base_Column_List\">"
		+"id,version,type"
	+"	</sql>"
	+"	<select id=\"selectById\" parameterType=\"Integer\" resultMap=\"BaseResultMap\">"
		+"	select "
		+"	<include refid=\"Base_Column_List\" />"
		+"	from tbs_version"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</select>"
	+"	<delete id=\"deleteById\" parameterType=\"Integer\">"
		+"	delete from tbs_version"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</delete>"
	+"	<insert id=\"insert\" keyColumn=\"id\" keyProperty=\"id\" parameterType=\"cn.sunline.tiny.demo.entity.TbsVersion\" useGeneratedKeys=\"true\">"
		+"	insert into tbs_version"
		+"	<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"
			+"<if test=\"id != null\">"
				+"id,"
			+"</if>"
			+"<if test=\"version != null\">"
				+"version,"
			+"</if>"
			+"<if test=\"type != null\">"
				+"type,"
			+"</if>"
		+"	</trim>"
		+"	<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"
			+"<if test=\"id != null\">"
				+"#{id,jdbcType=INTEGER},"
			+"</if>"
			+"<if test=\"version != null\">"
				+"#{version,jdbcType=VARCHAR},"
			+"</if>"
			+"<if test=\"type != null\">"
				+"#{type,jdbcType=INTEGER},"
			+"</if>"
		+"	</trim>"
	+"	</insert>"
	+"	<update id=\"updateById\" parameterType=\"cn.sunline.tiny.demo.entity.TbsVersion\">"
		+"	update tbs_version"
		+"	<set>"
		+"	<if test=\"version != null\">"
			+"version = #{version,jdbcType=VARCHAR},"
		+"	</if>"
		+"	<if test=\"type != null\">"
			+"type = #{type,jdbcType=INTEGER},"
		+"	</if>"
		+"	</set>"
		+"	where id = #{id,jdbcType=INTEGER}"
	+"	</update>";
	}
}