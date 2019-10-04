import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ���Ԃ̏d�Ȃ�`�F�b�N�ۑ�̎��s�N���X.
 * 
 * @author takahiro.araki
 *
 */
public class Execute {

	public static void main(String[] args) throws IOException, Exception {

		List<List<String>> mainList = setDate("C:\\env\\app\\study\\overlap.csv");

		List<List<Date>> periodList = parseTime(mainList);
		
		List<PeriodDomain> answerList=calc(mainList,periodList);
		 System.out.println(answerList);
		

	}

	/**
	 * csv�t�@�C����ǂݍ���ŁA���ԃf�[�^�����X�g�ɋl�߂ĕԂ�.
	 * 
	 * @param csv�t�@�C��
	 * @return ���ԃf�[�^
	 */
	public static List<List<String>> setDate(String st) {
		// �t�@�C���ǂݍ��݂Ŏg�p����R�̃N���X
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;
		List<List<String>> mainList = new ArrayList<>();
		List<String> dateList;

		try {

			// �ǂݍ��݃t�@�C���̃C���X�^���X����
			// �t�@�C�������w�肷��
			fi = new FileInputStream(st);
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);
			// �ǂݍ��ݍs
			String line;

			// �ǂݍ��ݍs���̊Ǘ�
			int i = 0;

			// �񖼂��Ǘ�����ׂ̔z��
			String[] arr = null;

			// 1�s���ǂݍ��݂����{
			while ((line = br.readLine()) != null) {
				// �擪�s�͗�
				if (i == 0) {
					// �J���}�ŕ����������e��z��Ɋi�[����
					arr = line.split(",");

				} else {

					// �f�[�^���e���R���\�[���ɕ\��
					// �f�[�^������\��
					// �J���}�ŕ����������e��z��Ɋi�[
					String[] data = line.split(",");
					// �z��̒��g�����ʕ\������B�񖼕��J��Ԃ�
					int colno = 0;
					dateList = new ArrayList<>();
					for (String column : arr) {
						dateList.add(data[colno]);
						colno++;
					}
					mainList.add(dateList);

				}
				// �s���C���N�������g
				i++;

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return mainList;

	}

	/**
	 * �������date�^�ɂ��ă��X�g�ŕԂ��܂�.
	 * 
	 * @param date �����`���̕�����
	 * @return date�^���X�g
	 */
	public static List<List<Date>> parseTime(List<List<String>> mainList) {
		String start;
		String end;
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
		List<List<Date>> periodList = new ArrayList<>();
		List<Date> ldtList;
		Date ld1;
		Date ld2;
		for (List<String> dateList : mainList) {
			ldtList = new ArrayList<>();
			start = dateList.get(1);
			try {ld1 = dtf.parse(start);
			ldtList.add(ld1);
			}catch(ParseException e) {
				e.printStackTrace();
			}
			end = dateList.get(2);
			try {
				ld2 = dtf.parse(end);
				ldtList.add(ld2);
			} catch(ParseException e) {
				e.printStackTrace();
			}
	
			periodList.add(ldtList);
		}

		return periodList;

	}
	
	/**
	 * ���t�̔�r�������s��.
	 * @param mainList 
	 * @param periodList 
	 * @return ���ʂ̃��X�g
	 */
	public static List<PeriodDomain>calc(List<List<String>> mainList,List<List<Date>> periodList){
		List<PeriodDomain>answerList=new ArrayList<>();
		Date standardStart=periodList.get(0).get(0);
		Date standardEnd=periodList.get(0).get(1);
		PeriodDomain answer;
		for(int i=1;i<periodList.size();i++) {
			answer=new PeriodDomain();
			if(standardEnd.before(periodList.get(i).get(0))==true || standardStart.after(periodList.get(i).get(1))==true) {
				
				answer.setAnswer("�d�Ȃ��Ă��Ȃ�");
				answer.setStart(periodList.get(i).get(0).toString());
				answer.setEnd(periodList.get(i).get(1).toString());
			}else {
				answer.setAnswer("�d�Ȃ��Ă���");
				answer.setStart(periodList.get(i).get(0).toString());
				answer.setEnd(periodList.get(i).get(1).toString());
				
			}
			
			answerList.add(answer);
			
		}
		return answerList;
		
	}

		

}
