package Lsh0708_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class Lsh0708_projectMainClass extends JFrame {

	Lsh0708_Project_DAO dao = new Lsh0708_Project_DAO();

	private JComboBox<String> deptCombo;
	private JComboBox<String> departmentField;
	private JPanel SearchPanel;
	private JPanel SearchDetailPanel;
	private JPanel ViewPanel;
	private JPanel ResultPanel;
	private JPanel UpdatePanel;
	private JPanel MainPanel;
	private JTable ViewTable;
	private JLabel searchResult;
	private JTextField nameField;
	// private JTextField departmentField;
	private JTextField birthdateField;
	private JTextField addressField;
	private JTextField phoneField;
	private ButtonGroup genderGroup;
	private JRadioButton maleButton;
	private JRadioButton femaleButton;
	private ArrayList<JCheckBox> checkBoxList;
	private ArrayList<String> selectedOptions;
	private String[] columnNames_KOR = { "사번", "이름", "부서", "생년월일", "주소", "전화번호", "성별" };
	private String[] columnNames_ENG = { "id", "name", "department", "birthdate", "address", "telNum", "sex" };
	private String[] deptColumn = { "전체", "연구소", "생산부", "영업부", "관리부"};
	public Lsh0708_projectMainClass() {

		setTitle("사내 직원 검색 프로그램 V 1.0.0");
		// 창 사이즈. 기본 크기.
		setSize(1000, 600);
		setLocationRelativeTo(null); // 화면 가운데 정렬
		// 창의 닫기를 클릭시, 정상 종료.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MainPanel = new JPanel();
		MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));

		SearchPanel = new JPanel();
		SearchPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		SearchPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		SearchPanel.add(new JLabel("검색 범위"));
		SearchPanel.setPreferredSize(new Dimension(1000, 50));
		deptCombo = new JComboBox<String>();
		SearchPanel.add(deptCombo);
		for(int i = 0;i<deptColumn.length;i++) {
			deptCombo.addItem(deptColumn[i]);
		}

		
		SearchDetailPanel = new JPanel();
		SearchDetailPanel.setBorder(BorderFactory.createLineBorder(Color.PINK));
		SearchDetailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		SearchDetailPanel.setPreferredSize(new Dimension(1000, 50));
		SearchDetailPanel.add(new JLabel("검색 항목"));
		checkBoxList = new ArrayList<>();
		selectedOptions = new ArrayList<>();
		
		for (int i = 0; i < columnNames_ENG.length; i++) {
            selectedOptions.add(columnNames_ENG[i]);
        }

		for(int i = 0; i < columnNames_KOR.length; i++ ) {
			JCheckBox checkBox = new JCheckBox(columnNames_KOR[i],true);
            checkBoxList.add(checkBox);
            //selectedOptions.add(null); // 선택된 항목을 null로 초기화
            checkBox.addItemListener(createItemListener(i));
            checkBoxList.add(checkBox);
            SearchDetailPanel.add(checkBox);
            
		}

		JButton SerchButton = new JButton("검색");
		SearchDetailPanel.add(SerchButton);
		SearchDetailPanel.setPreferredSize(new Dimension(1000, 50));

		ViewPanel = new JPanel();
		ViewPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		ViewPanel.setLayout(new FlowLayout());
		ViewPanel.setPreferredSize(new Dimension(1000, 400));

		ResultPanel = new JPanel();
		ResultPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		ResultPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		searchResult = new JLabel("검색 결과 수: ");
		ResultPanel.add(searchResult);
		ResultPanel.add(new JLabel("선택한 직원 :"));
		ResultPanel.setPreferredSize(new Dimension(1000, 100));

		UpdatePanel = new JPanel();
		UpdatePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		UpdatePanel.setLayout(new FlowLayout());
		UpdatePanel.add(new JLabel("새로운 직원 추가"));
		JButton addButton = new JButton("추가");
		UpdatePanel.add(addButton);
		UpdatePanel.add(new JLabel("선택한 데이터 삭제"));
		JButton deleteButton = new JButton("삭제");
		UpdatePanel.add(deleteButton);
		UpdatePanel.setSize(1000, 200);

		add(MainPanel);
		MainPanel.add(SearchPanel);
		MainPanel.add(SearchDetailPanel);
		MainPanel.add(ViewPanel);
		MainPanel.add(ResultPanel);
		MainPanel.add(UpdatePanel);

		SerchButton.addActionListener(e -> searchUser());
		addButton.addActionListener(e -> addUserWindow());
		deleteButton.addActionListener(e -> searchUserFinal());

//		deptCombo.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String selectedDepartment = (String) deptCombo.getSelectedItem();
//				System.out.println("선택된 아이템: " + selectedDepartment);
//				if (selectedDepartment.equals("전체")) {
//					searchUser();
//				} else {
//					selectedDept(selectedDepartment); // 선택한 부서에 따른 데이터 로드
//				}
//
//			}
//		});

		setVisible(true);
	}

	private void addUserWindow() {
		JFrame newFrame = new JFrame("직원 추가");
		newFrame.setSize(300, 300);
		newFrame.setLocationRelativeTo(null);
		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 새 창만 닫기
		newFrame.setLayout(new GridBagLayout()); // 그리드 백 레이아웃 사용

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5); // 패딩 설정

		// 입력 필드 및 레이블 생성
		gbc.gridx = 0;
		gbc.gridy = 0;
		newFrame.add(new JLabel("이름:"), gbc);

		gbc.gridx = 1;
		nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(200, 25));
		newFrame.add(nameField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		newFrame.add(new JLabel("부서:"), gbc);
		gbc.gridx = 1;
		departmentField = new JComboBox<String>();
		for(int i=1;i<deptColumn.length;i++) {
			departmentField.addItem(deptColumn[i]);
		}
		departmentField.setPreferredSize(new Dimension(200, 25));
		newFrame.add(departmentField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		newFrame.add(new JLabel("생년월일 (YYYY-MM-DD):"), gbc);
		gbc.gridx = 1;
		birthdateField = new JTextField();
		birthdateField.setEditable(false);
		birthdateField.setPreferredSize(new Dimension(200, 25));
		newFrame.add(birthdateField, gbc);

		birthdateField.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				showDatePicker();
			}
		});

		gbc.gridx = 0;
		gbc.gridy = 3;
		newFrame.add(new JLabel("주소:"), gbc);
		gbc.gridx = 1;
		addressField = new JTextField();
		addressField.setPreferredSize(new Dimension(200, 25));
		newFrame.add(addressField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		newFrame.add(new JLabel("전화 번호:"), gbc);
		gbc.gridx = 1;
		phoneField = new JTextField();
		phoneField.setPreferredSize(new Dimension(200, 25));
		newFrame.add(phoneField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		newFrame.add(new JLabel("성별:"), gbc);
		// 성별을 위한 라디오 버튼 생성
		maleButton = new JRadioButton("남");
		maleButton.setSelected(true);
		femaleButton = new JRadioButton("여");
		genderGroup = new ButtonGroup(); // 라디오 버튼 그룹 생성
		genderGroup.add(maleButton);
		genderGroup.add(femaleButton);

		// 라디오 버튼을 패널에 추가
		JPanel genderPanel = new JPanel();
		genderPanel.add(maleButton);
		genderPanel.add(femaleButton);
		gbc.gridx = 1;
		gbc.gridy = 5;
		newFrame.add(genderPanel, gbc);

		// 사용자 추가 버튼 생성
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2; // 버튼이 두 열을 차지하도록 설정
		gbc.anchor = GridBagConstraints.CENTER; // 중앙 정렬
		JButton addUserButton = new JButton("신규 직원 추가");
		addUserButton.setPreferredSize(new Dimension(120, 40));
		newFrame.add(addUserButton, gbc);

		addUserButton.addActionListener(e -> addUser());

		newFrame.setVisible(true); // 새 창 표시
	}

	private ItemListener createItemListener(int index) {
        return e -> {
        	String checkItemName="";
            JCheckBox checkBox = (JCheckBox) e.getItem();
            
            if (e.getStateChange() == ItemEvent.SELECTED) {
            	switch(checkBox.getText()) {
            	case "사번":
            		checkItemName = "id";
            		break;
            	case "이름":
            		checkItemName = "name";
            		break;
            	case "부서":
            		checkItemName = "department";
            		break;
            	case "생년월일":
            		checkItemName = "birthdate";
            		break;
            	case "주소":
            		checkItemName = "address";
            		break;
            	case "전화번호":
            		checkItemName = "telNum";
            		break;
            	case "성별":
            		checkItemName = "sex";
            		break;
            	}
                selectedOptions.set(index, checkItemName); // 체크된 항목 추가
            } else {
            	switch(checkBox.getText()) {
            	case "사번":
            		checkItemName = "id";
            		break;
            	case "이름":
            		checkItemName = "name";
            		break;
            	case "부서":
            		checkItemName = "department";
            		break;
            	case "생년월일":
            		checkItemName = "birthdate";
            		break;
            	case "주소":
            		checkItemName = "address";
            		break;
            	case "전화번호":
            		checkItemName = "telNum";
            		break;
            	case "성별":
            		checkItemName = "sex";
            		break;	
            	}
                selectedOptions.set(index,null); // 해제된 항목 제거
            }
            // 선택된 항목 리스트 출력
            System.out.println("현재 선택된 항목: " + selectedOptions);
        };
    }

	
	
	
	private void showDatePicker() {

		// JDatePicker 설정
		UtilDateModel model = new UtilDateModel();
		Properties properties = new Properties();
		properties.put("text.today", "오늘");
		properties.put("text.month", "월");
		properties.put("text.year", "년");

		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

		int result = JOptionPane.showConfirmDialog(this, datePicker, "날짜 선택", JOptionPane.OK_CANCEL_OPTION);

		// 날짜 선택 시 텍스트 필드에 날짜를 설정
		if (result == JOptionPane.OK_OPTION) {
			java.util.Date selectedDate = (java.util.Date) datePicker.getModel().getValue();
			if (selectedDate != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				birthdateField.setText(dateFormat.format(selectedDate));
			}
		}

	}

	private void selectedDept(String dept) {
		ArrayList<Lsh0708_project_DTO> list = dao.select(dept);
		if (list == null || list.isEmpty()) {
			JOptionPane.showMessageDialog(this, "데이터가 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		searchResult.setText("검색 결과 수: " + list.size());
		Object[][] data = new Object[list.size()][columnNames_ENG.length];
		
		for (int i = 0; i < list.size(); i++) {
			Lsh0708_project_DTO dto = list.get(i);

			int id = dto.getId();
			String name = dto.getName();
			String department = dto.getDepartment();
			String birthdate = dto.getBirthdate();
			String address = dto.getAddress();
			String telNum = dto.getTelNum();
			String sex = dto.getSex();

			data[i][0] = id; // ID
			data[i][1] = name; // Name
			data[i][2] = department; // Department
			data[i][3] = birthdate; // Birthdate
			data[i][4] = address; // Address
			data[i][5] = telNum; // TelNum
			data[i][6] = sex; // Sex
			System.out.println(
					id + "," + name + "," + department + "," + birthdate + "," + address + "," + telNum + "," + sex);

		}
//		String[] array = selectedOptions.toArray(new String[0]);
//		updateTable(data,array);
		updateTable(data);
	}

	private void addUser() {
		if (nameField.getText().isEmpty() || birthdateField.getText().isEmpty() || addressField.getText().isEmpty()
				|| phoneField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "모든 필드를 채워주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
			return; // 메서드 종료
		}
		String userName = nameField.getText();
		String userDept = (String) departmentField.getSelectedItem();
		String userBirth = birthdateField.getText();
		String userAdd = addressField.getText();
		String userTelNum = phoneField.getText();
		String userSex;
		if (maleButton.isSelected()) {
			userSex = "Male";
		} else if (femaleButton.isSelected()) {
			userSex = "Female";
		} else {
			userSex = "Not Selected"; // 성별이 선택되지 않은 경우
		}

		int result = dao.insertDB(userName, userDept, userBirth, userAdd, userTelNum, userSex);
		System.out.println("DAO 에서 insert 기능 추가 후 : 값반환:" + result + "개 추가됨.");
		nameField.setText("");

		birthdateField.setText("");
		addressField.setText("");
		phoneField.setText("");
		maleButton.setSelected(true);

	}
	private void searchUserFinal() {
		ArrayList<Lsh0708_project_DTO> list = dao.select((String) deptCombo.getSelectedItem() ,selectedOptions);
		Object[][] data = new Object[list.size()][selectedOptions.size()];
//		for(int i =0;i<list.size();i++) {
//			Lsh0708_project_DTO dto = list.get(i);
//			for(int j=0;j<selectedOptions.size();j++) {
//				System.out.println(dto);
//			}
//		}
		searchResult.setText("검색 결과 수: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			Lsh0708_project_DTO dto = list.get(i);

			int id = dto.getId();
			String name = dto.getName();
			String department = dto.getDepartment();
			String birthdate = dto.getBirthdate();
			String address = dto.getAddress();
			String telNum = dto.getTelNum();
			String sex = dto.getSex();

			data[i][0] = id; // ID
			data[i][1] = name; // Name
			data[i][2] = department; // Department
			data[i][3] = birthdate; // Birthdate
			data[i][4] = address; // Address
			data[i][5] = telNum; // TelNum
			data[i][6] = sex; // Sex
			System.out.println(
					id + "," + name + "," + department + "," + birthdate + "," + address + "," + telNum + "," + sex);

		}
//		String[] array = selectedOptions.toArray(new String[0]);
//		updateTable(data,array);
		updateTable(data);

	}
	private void searchUser() {
		ArrayList<Lsh0708_project_DTO> list = dao.select();
		Object[][] data = new Object[list.size()][columnNames_ENG.length];
		searchResult.setText("검색 결과 수: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			Lsh0708_project_DTO dto = list.get(i);

			int id = dto.getId();
			String name = dto.getName();
			String department = dto.getDepartment();
			String birthdate = dto.getBirthdate();
			String address = dto.getAddress();
			String telNum = dto.getTelNum();
			String sex = dto.getSex();

			data[i][0] = id; // ID
			data[i][1] = name; // Name
			data[i][2] = department; // Department
			data[i][3] = birthdate; // Birthdate
			data[i][4] = address; // Address
			data[i][5] = telNum; // TelNum
			data[i][6] = sex; // Sex
			System.out.println(
					id + "," + name + "," + department + "," + birthdate + "," + address + "," + telNum + "," + sex);

		}
//		String[] array = selectedOptions.toArray(new String[0]);
//		updateTable(data,array);
		updateTable(data);

	}

	private void updateTable(Object[][] data) {
		ViewTable = new JTable(data, columnNames_KOR);
		ViewTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); // 모든 열 크기를 자동으로 조정
		JScrollPane scrollPane = new JScrollPane(ViewTable);
		ViewPanel.setLayout(new BorderLayout());
		ViewPanel.removeAll(); // 기존 컴포넌트를 제거
		ViewPanel.add(scrollPane, BorderLayout.CENTER);
		ViewPanel.revalidate();
		ViewPanel.repaint();
	}
	private void updateTable(Object[][] data, String [] checkedCol) {
		ViewTable = new JTable(data, checkedCol);
		ViewTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); // 모든 열 크기를 자동으로 조정
		JScrollPane scrollPane = new JScrollPane(ViewTable);
		ViewPanel.setLayout(new BorderLayout());
		ViewPanel.removeAll(); // 기존 컴포넌트를 제거
		ViewPanel.add(scrollPane, BorderLayout.CENTER);
		ViewPanel.revalidate();
		ViewPanel.repaint();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Lsh0708_projectMainClass();
	}

}
