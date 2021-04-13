package mainUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class CustomJTable extends JTable{
	
	public CustomJTable(DefaultTableModel model) {
		super();
		
		this.setModel(model);
		this.setBorder(new LineBorder(Color.LIGHT_GRAY));
		this.setRowHeight(25);
		this.setRowMargin(0);
		this.setIntercellSpacing(new Dimension(0, 0));
		this.setGridColor(Color.WHITE);
		this.setForeground(Color.DARK_GRAY);
		this.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		this.setShowVerticalLines(false);
		this.setShowHorizontalLines(false);
		this.setShowGrid(false);
		this.setOpaque(false);
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setBackground(Color.WHITE);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JTableHeader header = this.getTableHeader();
		header.setBackground(Color.WHITE);
		header.setForeground(Color.DARK_GRAY);
		header.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		header.setBorder(new LineBorder(Color.LIGHT_GRAY));
		header.setResizingAllowed(false); // 크기 조절 불가
		header.setReorderingAllowed(false); // 셀 좌우 이동 불가
	}
}
