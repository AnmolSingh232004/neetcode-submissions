class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder());

        return res;
    }

    public void dfs(int n, int openCount, int closeCount, StringBuilder paren) {
        if (openCount == n && closeCount == n) {
            res.add(new String(paren));
            return;
        }
        
        if (openCount > n || closeCount > n || closeCount > openCount) {
            return;
        }

        paren.append('(');
        dfs(n, openCount + 1, closeCount, paren);
        paren.deleteCharAt(paren.length() - 1);

        paren.append(')');
        dfs(n, openCount, closeCount + 1, paren);
        paren.deleteCharAt(paren.length() - 1);

    }
}

// every call will have option to include ( or )
// we will keep track of open and close parenthese
// if at any point either surpasses 'n' which means more than half the elements have ( or ), in that case we return since its bad case 
// and also techincally ) should never outnumber open therefore if closeCount > openCount that is bad parentheses too

// if opencount == n && clsoecount == n, this means both add upto a valid parentheses since these will have ( always before ) thanks to basecases
// in this case we add this combo to res

// we add (, increase openCount, then backtrack with it and remove it later

// then we add ), backtrack with it and remove later

// we must ensure we increase open count when adding ( and increase clsoe count when adding )