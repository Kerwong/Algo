#include "Solution.h"

using namespace std;

int main(){
	struct TreeNode* nd1 = new TreeNode(0);
	struct TreeNode* nd2 = new TreeNode(1);
	struct TreeNode* nd3 = new TreeNode(1);

	nd1->left = nd2;
	nd1->right = nd3;

	Solution* sol = new Solution();
	sol->hasPathSum(nd1, 1);

	return 0;
}