
/**
 * �@�ւ̏d�Ȃ�ۑ�̃A���T�[�h���C��.
 * @author takahiro.araki
 *
 */
public class PeriodDomain {
	
	/**���� */
	private String period;
	/**�@�ւ̊J�n�_ */
	private String start;
	/**�@�ւ̏I���n�_*/
	private String end;
	/**���� */
	private String answer;
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "PeriodDomain [period=" + period + ", start=" + start + ", end=" + end + ", answer=" + answer + "]";
	}
	
	

	
	
}
