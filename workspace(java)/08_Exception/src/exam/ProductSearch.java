package exam;

import javax.swing.JOptionPane;

public class ProductSearch {

	public static void main(String[] args) {
		
		String productName =
		   JOptionPane.showInputDialog("검색할 상품명을 입력하세요.");
		
		ProductSearchData ps = new ProductSearchData();
		
		String productInfo = ps.search(productName);
		
		try {
			productInfo.length();  // 예외가 발생할 가능성이 있는 코드
			JOptionPane.showMessageDialog(null, productInfo);
		}catch(Exception e) {
			// 예외가 발생했을 때 처리할 문장.
			System.out.println("해당 상품이 없습니다.");
			JOptionPane.showMessageDialog
				(null, "해당 상품이 없습니다.");
		}
		
		

	}

}
