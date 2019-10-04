
/**
 * 機関の重なり課題のアンサードメイン.
 * @author takahiro.araki
 *
 */
public class PeriodDomain {
	
	/**期間 */
	private String period;
	/**機関の開始点 */
	private String start;
	/**機関の終了地点*/
	private String end;
	/**答え */
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
