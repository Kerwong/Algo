#include <string>

using namespace std;

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };

class Solution {
public:
    int minDepth(TreeNode *root) {
        if(root == NULL)
			return 0;

		int ldep = minDepth(root->left);
		int rdep = minDepth(root->right);

		if(root->left == NULL && root->right == NULL)
			return 1;
		else if(root->left != NULL && root->right == NULL)
			return ldep + 1;
		else if(root->left == NULL && root->right != NULL)
			return rdep + 1;
		else {
			if(ldep < rdep)
				return ldep + 1;
			else
				return rdep + 1;
		}
    }

	int maxDepth(TreeNode *root) {
        if(root == NULL)
			return 0;

		int ldep = maxDepth(root->left);
		int rdep = maxDepth(root->right);

		if(root->left == NULL && root->right == NULL)
			return 1;
		else if(root->left != NULL && root->right == NULL)
			return ldep + 1;
		else if(root->left == NULL && root->right != NULL)
			return rdep + 1;
		else {
			if(ldep < rdep)
				return rdep + 1;
			else
				return ldep + 1;
		}
    }
};