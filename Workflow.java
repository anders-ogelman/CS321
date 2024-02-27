public class Workflow {

	private int wfid;
	private String step;
	private int objid;

	public Workflow(int wfid, String step, int objid) {
		this.wfid = wfid;
		this.step = step;
		this.objid = objid;
	}

	public boolean addWFItem(String step, int objid) {
		System.out.println("testing upload");
		return true;
	}

	public int getNextWFItem(String step) {
		return objid;
	}

	public int countWFItems(String step) {
		return 1;
	}

}
