package br.poli.ecomp.gr.snmpoli.pojo;

import java.io.IOException;
import java.util.List;

import br.poli.ecomp.gr.snmpoli.interfaces.Encodable;
import br.poli.ecomp.gr.snmpoli.util.ByteArrayBuilder;

public class SNMPPDU implements Encodable {

	public interface ERROR_STATUS {
		public static final int NO_ERROR = 0;
		public static final int TOO_BIG = 1;
		public static final int NO_SUCH_NAME = 2;
		public static final int BAD_VALUE = 3;
		public static final int READ_ONLY = 4;
		public static final int GENERAL_ERROR = 5;
	}

	private int requestId;
	private int errorStatus;
	private int errorIndex;
	private List<VarBind> varbinds;

	public byte[] encode() {
		ByteArrayBuilder builder = new ByteArrayBuilder();
		try {
			builder.writeInt(requestId)
			.writeInt(errorStatus)
			.writeInt(errorIndex);
			
			for (VarBind varBind : varbinds) {
				builder.writeBytes(varBind.encode());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.getBytes();
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(int errorStatus) {
		this.errorStatus = errorStatus;
	}

	public int getErrorIndex() {
		return errorIndex;
	}

	public void setErrorIndex(int errorIndex) {
		this.errorIndex = errorIndex;
	}

	public List<VarBind> getVarbinds() {
		return varbinds;
	}

	public void setVarbinds(List<VarBind> varbinds) {
		this.varbinds = varbinds;
	}

}
