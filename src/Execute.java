import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 期間の重なりチェック課題の実行クラス.
 * @author takahiro.araki
 *
 */
public class Execute {
	
	public static void main(String[] args) throws IOException, Exception{
		// テキストファイルをリストに入れる
					String path = "C:\\env\\app\\study\\overlap.csv";
					List<String> text = readString(path);
		
					
					
	}
	

			/**
			 * テキストファイルを読み込みます.
			 * 
			 * @param path 読み込むファイルのパス
			 * @return ファイルの内容
			 * @throws IOException
			 */
			public static List<String> readString(String path) throws IOException {
				return Files.readAllLines(Paths.get(path), Charset.forName("UTF-8"));
			}
			
			
}

