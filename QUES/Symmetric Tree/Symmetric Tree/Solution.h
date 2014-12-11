#include <vector>
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
	bool isOpposite(TreeNode *ltree, TreeNode *rtree) {
		if(ltree->val != rtree->val)
			return false;

		if(ltree->left!=NULL && rtree->right!=NULL) {
			if(!isOpposite(ltree->left, rtree->right))
				return false;
		} else if(ltree->left==NULL && rtree->right==NULL) {

		} else {
			return false;
		}
		
		if(ltree->right!=NULL && rtree->left!=NULL) {
			if(!isOpposite(ltree->right, rtree->left))
				return false;
		} else if(ltree->right==NULL && rtree->left==NULL) {

		} else {
			return false;
		}

		return true;
	}

	bool isSameTree(TreeNode *p, TreeNode *q) {
		if(p == NULL && q == NULL)
			return true;
		else if(p == NULL || q == NULL)
			return false;

		if(p->val != q->val)
			return false;

		if(p->left!=NULL && q->left!=NULL) {
			if(!isSameTree(p->left, q->left))
				return false;
		} else if(p->left==NULL && q->left==NULL) {

		} else {
			return false;
		}
		
		if(p->right!=NULL && q->right!=NULL) {
			if(!isSameTree(p->right, q->right))
				return false;
		} else if(p->right==NULL && q->right==NULL) {

		} else {
			return false;
		}

		return true;
	}

    bool isSymmetric(TreeNode *root) {
        if(root == NULL)
			return true;

		TreeNode *ltree = root->left;
		TreeNode *rtree = root->right;

		if(ltree==NULL && rtree==NULL) {
			return true;
		} else if(ltree!=NULL && rtree!=NULL) {
			if(isOpposite(ltree, rtree))
			return true;
		} else {
			return false;
		}

		return false;
    }
};

