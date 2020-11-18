package cn.sunline.tiny.flow.util;

public class CodeMsg {
		private int retCode;
		private String message;
		// 按照模块定义CodeMsg
		// 通用异常
		public static CodeMsg SERVER_EXCEPTION = new CodeMsg(000001,"{\"sys\":{\"status\":\"F\",\"erorcd\":\"000001\",\"erortx\":\"您还未登录，请先去登录！\"}}");
	    public static CodeMsg PARAMETER_ISNULL = new CodeMsg(500101,"输入参数为空");
      	public static CodeMsg PHONE_EXIST = new CodeMsg(599999,"手机号已经存在");
	    public static CodeMsg REGISTERED_SUCCEED  = new CodeMsg(59998,"注册成功");
	    public static CodeMsg REAL_NAME  = new CodeMsg(59997,"你还未实名认证，请先实名认证");
	    public static CodeMsg CODE_ERROR  = new CodeMsg(59996,"验证码错误");
	    public static CodeMsg SUCCESS = new CodeMsg(59995,"success");
	    public static CodeMsg NO_RESULT = new CodeMsg(59994,"查询不到相关记录");

	// 业务异常
		public static CodeMsg USER_NOT_EXSIST = new CodeMsg(500102,"用户不存在,请先注册");

		public static CodeMsg ONLINE_USER_OVER = new CodeMsg(500103,"在线用户数超出允许登录的最大用户限制。"); 
		public static CodeMsg SESSION_NOT_EXSIST =  new CodeMsg(500104,"不存在离线session数据");
		public static CodeMsg NOT_FIND_DATA = new CodeMsg(500105,"查找不到对应数据");
		
		private CodeMsg(int retCode, String message) {
			this.retCode = retCode;
			this.message = message;
		}
		public int getRetCode() {
			return retCode;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
}

