import com.sun.source.util.Trees;
import java.util.Hashtable;
import java.util.TreeSet;

public class 레드블랙트리 {
    
    public class Node {

        int data;

        boolean isRed;
        Node leftChild;
        Node rightChild;

        Node parent;

        public Node(int data, Node parent) {
            this.data = data;
            this.parent = parent;
            isRed = true;
        }

        public void add(int data) {
            Node curNode = this;
            Node parent = null;

            while(curNode != null) {
                parent = curNode;
                if (curNode.data < data) {
                    curNode = rightChild;
                } else {
                    curNode = leftChild;
                }
            }

            curNode = new Node(data, parent);

            while(isTwoRedTree(curNode, curNode.parent)) {
                Node grandParent = curNode.parent.parent;

                if(grandParent == null) {
                    curNode.parent.isRed = false;
                    break;
                }

                Node uncle;

                if(grandParent.rightChild == curNode.parent) {
                    uncle = grandParent.leftChild;
                } else {
                    uncle = grandParent.rightChild;
                }

                if(uncle != null && uncle.isRed) {
                    uncle.isRed = false;
                    parent.isRed = false;
                } else {
                    if(curNode == parent.leftChild) {
                        grandParent.leftChild = parent.rightChild;
                        parent.parent = grandParent.parent;
                        grandParent.parent = parent;
                        parent.rightChild = grandParent;
                    } else {

                    }
                }


            }
        }

        private boolean isTwoRedTree(Node cur, Node parent) {
            if(parent == null) {
                cur.isRed = false;
                return false;
            }
            return cur.isRed && parent.isRed;
        }

    }

    public static void main(String[] args) {
        레드블랙트리 tree = new 레드블랙트리();
    }



}

/**
 * 레드 블랙 트리
 * 루트 노드는 검정
 * 새로운 노드는 빨강
 * 연속되서 빨강 노드가 나타나면 안됨.
 * 루트 노트 부터 어떤 NIL노드까지 검정 노드의 개수는 같아야함.
 */

/**
 * 삽입 시, 레드 노드가 두 번 연속일 경우, 삼촌노드를 확인 후,
 * 삼촌 노드가 레드면, recoloring
 * 검정이면 reconstruct를 진행
 *
 */
