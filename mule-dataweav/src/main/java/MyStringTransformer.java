import java.util.HashMap;
import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class MyStringTransformer extends AbstractMessageTransformer{

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		
		@SuppressWarnings("unchecked")
		Map<String,String> objParam=(Map<String,String>)message.getInboundProperty("http.query.params");
		HashMap<String,String> sh=new HashMap<String,String>();
		String s=message.getInvocationProperty("myVar");
		sh.put("name",objParam.get("name"));
		sh.put("age",objParam.get("age"));
		//System.out.println(objParam.get("name"));
		return sh;
	}

}
