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
 * 期間の重なりチェック課題の実行クラス.
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
	 * csvファイルを読み込んで、期間データをリストに詰めて返す.
	 * 
	 * @param csvファイル
	 * @return 期間データ
	 */
	public static List<List<String>> setDate(String st) {
		// ファイル読み込みで使用する３つのクラス
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;
		List<List<String>> mainList = new ArrayList<>();
		List<String> dateList;

		try {

			// 読み込みファイルのインスタンス生成
			// ファイル名を指定する
			fi = new FileInputStream(st);
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);
			// 読み込み行
			String line;

			// 読み込み行数の管理
			int i = 0;

			// 列名を管理する為の配列
			String[] arr = null;

			// 1行ずつ読み込みを実施
			while ((line = br.readLine()) != null) {
				// 先頭行は列名
				if (i == 0) {
					// カンマで分割した内容を配列に格納する
					arr = line.split(",");

				} else {

					// データ内容をコンソールに表示
					// データ件数を表示
					// カンマで分割した内容を配列に格納
					String[] data = line.split(",");
					// 配列の中身を順位表示する。列名分繰り返す
					int colno = 0;
					dateList = new ArrayList<>();
					for (String column : arr) {
						dateList.add(data[colno]);
						colno++;
					}
					mainList.add(dateList);

				}
				// 行数インクリメント
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
	 * 文字列をdate型にしてリストで返します.
	 * 
	 * @param date 日時形式の文字列
	 * @return date型リスト
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
	 * 日付の比較処理を行う.
	 * @param mainList 
	 * @param periodList 
	 * @return 結果のリスト
	 */
	public static List<PeriodDomain>calc(List<List<String>> mainList,List<List<Date>> periodList){
		List<PeriodDomain>answerList=new ArrayList<>();
		Date standardStart=periodList.get(0).get(0);
		Date standardEnd=periodList.get(0).get(1);
		PeriodDomain answer;
		for(int i=1;i<periodList.size();i++) {
			answer=new PeriodDomain();
			if(standardEnd.before(periodList.get(i).get(0))==true || standardStart.after(periodList.get(i).get(1))==true) {
				
				answer.setAnswer("重なっていない");
				answer.setStart(periodList.get(i).get(0).toString());
				answer.setEnd(periodList.get(i).get(1).toString());
			}else {
				answer.setAnswer("重なっている");
				answer.setStart(periodList.get(i).get(0).toString());
				answer.setEnd(periodList.get(i).get(1).toString());
				
			}
			
			answerList.add(answer);
			
		}
		return answerList;
		
	}

		

}
