package com.spring.model;

import java.util.List;

public interface EmpDAO {

	public List<EmpDTO> getEmpList();
	
	public List<DeptDTO> getDeptList();
	
	public List<EmpDTO> getMgrList();
	
	public int insertEmp(EmpDTO dto);
	
	public EmpDTO getCont(int empno);
	
	public int updateEmp(EmpDTO dto);
	
	public int deleteEmp(int empno);
	
}
