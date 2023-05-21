#include <iostream>
#include <vector>

using namespace std;

struct Node{
    string value;
    struct Node *left{};
    struct Node *right{};
};

void insert(Node *&root, const string &v){
    if(root == nullptr){
    root = new Node;
    root->value = v;
    root->left = nullptr;
    root->right = nullptr;
    }else if(v != root->value){
        if(v < root->value){
            insert(root->left, v);
        }else{
            insert(root->right, v);
        }
    }
}

void list(Node *root){
    if(root != nullptr){
        list(root->left);
        cout << root->value << "; ";
        list(root->right);
    }
}

void free(Node *root){
    if(root != nullptr){
        free(root->left);
        free(root->right);
        root->left = nullptr;
        root->right = nullptr;
    }
}

int main(){
    string input;
    Node *root = nullptr;
    while(true){
        getline(cin,input);
        if(input == "."){
            break;
        }
        insert(root, input);
    }
    list(root);
    free(root);
    return 0;
}