package openapi;

import java.util.ArrayList;

public class DeptController {
	public static void main(String[] args) {
		DeptLogic deptlogic = new DeptLogic();
		ArrayList<XMLDeptDTO> deptlist = deptlogic.getDeptList();
		for (int i = 0; i < deptlist.size(); i++) {
			XMLDeptDTO dept = deptlist.get(i);
			System.out.print(dept.getCode()+"\t");
			System.out.print(dept.getName()+"\t");
			System.out.print(dept.getLoc()+"\t");
			System.out.println(dept.getTel());
			
		}

	}

}
