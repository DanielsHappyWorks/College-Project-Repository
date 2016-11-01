import java.util.Comparator;

public class DefenceComparator implements Comparator<CharacterClass> {
	public int compare(CharacterClass c1, CharacterClass c2) {
		return c1.getDefence()-c2.getDefence();
	}
}
