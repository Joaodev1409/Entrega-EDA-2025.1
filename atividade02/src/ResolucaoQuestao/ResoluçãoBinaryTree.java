package ResolucaoQuestao;

import java.util.ArrayList;
import java.util.List;

public class ResoluçãoBinaryTree {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        List<TreeNode> nodeList = new ArrayList<>();

        public TreeNode balanceBST(TreeNode root) {
            emOrdem(root);
            return construirBSTBalanceada(0, nodeList.size() - 1);
        }

        void emOrdem(TreeNode node) {
            if (node == null) {
                return;
            }
            emOrdem(node.left);
            nodeList.add(node);
            emOrdem(node.right);
        }

        TreeNode construirBSTBalanceada(int inicio, int fim) {
            if (inicio > fim) {
                return null;
            }
            int meio = (inicio + fim) / 2;
            TreeNode raiz = nodeList.get(meio);
            raiz.left = construirBSTBalanceada(inicio, meio - 1);
            raiz.right = construirBSTBalanceada(meio + 1, fim);
            return raiz;
        }
    }
}
