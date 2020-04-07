public class ValidWordAbbr {
    Map<String, String> abbrMap;

    public ValidWordAbbr(String[] dictionary) {
        abbrMap = new HashMap<>();
        for (String word : dictionary) {
            String abbr = getAbbr(word);
            if (abbrMap.containsKey(abbr)) {
                String prev = abbrMap.get(abbr);
                if (prev != null && !prev.equals(word)) {
                    abbrMap.put(abbr, null);
                }
            } else {
                abbrMap.put(abbr, word);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !abbrMap.containsKey(abbr) || (abbrMap.get(abbr) != null && abbrMap.get(abbr).equals(word));
    }
    
    private String getAbbr(String word) {
        int len = word.length();
        if (len < 3) {
            return word;
        }
        return new StringBuilder().append(word.charAt(0)).append(len - 2).append(word.charAt(len - 1)).toString();
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
