/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
#include <string>

using namespace std;

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool hasPathSum(TreeNode *root, int sum) {
		if(root == NULL)
			return false;

		int cur = sum - root->val;
		/*if(cur < 0)	
			return false;
		else if(cur == 0){
			if(root->left == NULL && root->right == NULL)
				return true;
			else 
				return false;
		}*/

		if(root->left == NULL && root->right == NULL) {
			if(root->val == sum)
				return true;
			return false;
		} else if(root->left != NULL && root->right == NULL) {
			return hasPathSum(root->left, cur);
		} else if(root->left == NULL && root->right != NULL) {
			return hasPathSum(root->right, cur);
		} else {
			if(hasPathSum(root->left, cur) || hasPathSum(root->right, cur))
				return true;
			return false;
		}
    }
};