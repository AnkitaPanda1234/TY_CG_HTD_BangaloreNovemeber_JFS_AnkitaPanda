

public class Test {
	public static void main(String[] args) {
		String s1="john";
		String s2="mikel";
		System.out.println(s1.charAt(1));
		System.out.println(s1.codePointAt(2));
		System.out.println(s1.codePointBefore(2));
		System.out.println(s1.codePointCount(0, 2));
		System.out.println(s1.compareTo(null));
		System.out.println(s1.compareToIgnoreCase(s2));
		System.out.println(s1.concat(s2));
		System.out.println(s1.length());
		System.out.println(s1.toCharArray());
		System.out.println(s1.toLowerCase());
		System.out.println(s1.toUpperCase());
		System.out.println(s1.toString());
		System.out.println(s1.contains(s2));
		System.out.println(s1.contentEquals(s1));
		System.out.println(s1.codePointCount(1, 3));
		System.out.println(s1.endsWith(s2));
		System.out.println(s1.equals(s1));
		System.out.println(s1.equalsIgnoreCase(s2));
		System.out.println(s1.hashCode());
		System.out.println(s1.indexOf(3));
		System.out.println(s1.getBytes());
		System.out.println(s1.isEmpty());
		System.out.println(s1.lastIndexOf(3));
		System.out.println(s1.split(s1));
		System.out.println(s1.trim());
		System.out.println(s1.valueOf(false));
	}

}
