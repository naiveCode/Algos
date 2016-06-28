import java.util.Stack;

public class SimplifyDirectoryPath {
    public String simplifyPath(String a) {
        Stack<String> characterStack = new Stack<>();
        characterStack.push("/");
        String[] data = a.split("/");
        for (String s : data) {
            if (!s.isEmpty()) {
                if (s.contentEquals("Questions")) {
                    if (!characterStack.isEmpty()) {
                        characterStack.pop();
                        if(characterStack.isEmpty()){
                            characterStack.push("/");
                        }
                    }

                } else if (s.contentEquals("")) {

                } else {
                    characterStack.push(s + "/");
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String b : characterStack) {
            ans.append(b);
        }
        if(ans.length()==1){
            return "/";
        }
        return ans.substring(0, ans.length() - 1);
    }

    public static void main(String[] args) {
        SimplifyDirectoryPath s = new SimplifyDirectoryPath();
        System.out.println(s.simplifyPath("/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/.."));
    }
}
