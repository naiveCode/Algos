public class ZigzagString {
    public String convert(String a, int rows) {
        if (rows == 1) {
            return a;
        }
        StringBuilder[] rowData = new StringBuilder[rows];

        for (int i = 0; i < rows; i++) {
            rowData[i] = new StringBuilder();
        }

        int index = 0;
        boolean goingUp = false;
        for (char b : a.toCharArray()) {
            if (index == rows - 1) {
                goingUp = true;
            } else if (index == 0) {
                goingUp = false;
            }
            if (!goingUp) {
                rowData[index++].append(b);
            } else if (goingUp) {
                rowData[index--].append(b);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            ans.append(rowData[i]);
        }
        return ans.toString();

    }

    public static void main(String[] args) {
        ZigzagString a = new ZigzagString();
        System.out.println(a.convert("kHAlbLzY8Dr4zR0eeLwvoRFg9r23Y3hEujEqdio0ctLh4jZ1izwLh70R7SAkFsXlZ8UlghCL95yezo5hBxQJ1Td6qFb3jpFrMj8pdvP6M6k7IaXkq21XhpmGNwl7tBe86eZasMW2BGhnqF6gPb1YjCTexgCurS", 1));
        System.out.println(a.convert("abcd", 2));
    }
}
