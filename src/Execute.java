import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * ���Ԃ̏d�Ȃ�`�F�b�N�ۑ�̎��s�N���X.
 * @author takahiro.araki
 *
 */
public class Execute {
	
	public static void main(String[] args) throws IOException, Exception{
		// �e�L�X�g�t�@�C�������X�g�ɓ����
					String path = "C:\\env\\app\\study\\overlap.csv";
					List<String> text = readString(path);
		
					
					
	}
	

			/**
			 * �e�L�X�g�t�@�C����ǂݍ��݂܂�.
			 * 
			 * @param path �ǂݍ��ރt�@�C���̃p�X
			 * @return �t�@�C���̓��e
			 * @throws IOException
			 */
			public static List<String> readString(String path) throws IOException {
				return Files.readAllLines(Paths.get(path), Charset.forName("UTF-8"));
			}
			
			
}

