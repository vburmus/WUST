#include <iostream>
#include "CTreeDynamic.h"

using namespace std;

int main() {

    //First TreeDynamic

    CTreeDynamic<int> dynamicTree1;

    dynamicTree1.pcGetRoot()->vSetValue(1);

    dynamicTree1.pcGetRoot()->vAddNewChild();
    dynamicTree1.pcGetRoot()->vAddNewChild();
    dynamicTree1.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(2);
    dynamicTree1.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vSetValue(3);

    dynamicTree1.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vAddNewChild();
    dynamicTree1.pcGetRoot()->pcGetChild(1)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(4);

    dynamicTree1.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vAddNewChild();
    dynamicTree1.pcGetRoot()->pcGetChild(0)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(5);

    //Second TreeDynamic

    CTreeDynamic<int> dynamicTree2;
    dynamicTree2.pcGetRoot()->vSetValue(1);

    dynamicTree2.pcGetRoot()->vAddNewChild();
    dynamicTree2.pcGetRoot()->vAddNewChild();
    dynamicTree2.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(10);
    dynamicTree2.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vSetValue(20);

    dynamicTree2.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vAddNewChild();
    dynamicTree2.pcGetRoot()->pcGetChild(1)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(30);

    dynamicTree2.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vAddNewChild();
    dynamicTree2.pcGetRoot()->pcGetChild(0)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(40);



    cout << "\nCTreeDynamic #1 " << endl;
    dynamicTree1.vPrintFullTree();

    cout << "\nCTreeDynamic #2 " << endl;
    dynamicTree2.vPrintFullTree();

    dynamicTree1.bMoveSubtree(dynamicTree1.pcGetRoot()->pcGetChild(0)->pcGetRoot(), dynamicTree2.pcGetRoot()->pcGetChild(1)->pcGetRoot());

    cout << "\nCTreeDynamic #1 bMoveSubtree " << endl;
    dynamicTree1.vPrintFullTree();

    cout << "\nCTreeDynamic #2 bMoveSubtree " << endl;
    dynamicTree2.vPrintFullTree();
    
    CTreeDynamic<double> dynamicTreeTest1;

    dynamicTreeTest1.pcGetRoot()->vSetValue(2.3);

    dynamicTreeTest1.pcGetRoot()->vAddNewChild();
    dynamicTreeTest1.pcGetRoot()->vAddNewChild();
    dynamicTreeTest1.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(2.2);
    dynamicTreeTest1.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vSetValue(2.2);

    dynamicTreeTest1.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vAddNewChild();
    dynamicTreeTest1.pcGetRoot()->pcGetChild(1)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(2.2);

    dynamicTreeTest1.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vAddNewChild();
    dynamicTreeTest1.pcGetRoot()->pcGetChild(0)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(2.2);
    cout << "\n" << endl;

    
   
  

    CTreeDynamic<string> dynamicTreeTest2;

    dynamicTreeTest2.pcGetRoot()->vSetValue("c");

    dynamicTreeTest2.pcGetRoot()->vAddNewChild();
    dynamicTreeTest2.pcGetRoot()->vAddNewChild();
    dynamicTreeTest2.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue("c");
    dynamicTreeTest2.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vSetValue("c");

    dynamicTreeTest2.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vAddNewChild();
    dynamicTreeTest2.pcGetRoot()->pcGetChild(1)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue("c");

    dynamicTreeTest2.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vAddNewChild();
    dynamicTreeTest2.pcGetRoot()->pcGetChild(0)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue("c");
    CTreeDynamic<string> dynamicTreeTest3;

    dynamicTreeTest3.pcGetRoot()->vSetValue("a");

    dynamicTreeTest3.pcGetRoot()->vAddNewChild();
    dynamicTreeTest3.pcGetRoot()->vAddNewChild();
    dynamicTreeTest3.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue("a");
    dynamicTreeTest3.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vSetValue("a");

    dynamicTreeTest3.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vAddNewChild();
    dynamicTreeTest3.pcGetRoot()->pcGetChild(1)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue("a");

    dynamicTreeTest3.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vAddNewChild();
    dynamicTreeTest3.pcGetRoot()->pcGetChild(0)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue("a");
    
    cout << "\nCTreeDynamic #1  " << endl;
    dynamicTreeTest2.vPrintFullTree();

    cout << "\nCTreeDynamic #2  " << endl;
    dynamicTreeTest3.vPrintFullTree();

    dynamicTreeTest2.bMoveSubtree(dynamicTreeTest2.pcGetRoot()->pcGetChild(0)->pcGetRoot(), dynamicTreeTest3.pcGetRoot()->pcGetChild(1)->pcGetRoot());

    cout << "\nCTreeDynamic #1 bMoveSubtree " << endl;
    dynamicTreeTest2.vPrintFullTree();

    cout << "\nCTreeDynamic #2 bMoveSubtree " << endl;
    dynamicTreeTest3.vPrintFullTree();


    cout << "\n\n\nTest mod(2.2,a):" << endl;
    dynamicTreeTest1.vPrintFullTree();
    cout << "\n" << dynamicTreeTest1.iCount(2.2) << endl;
    dynamicTreeTest2.vPrintFullTree();
    cout << "\n" << dynamicTreeTest2.iCount("a") << endl;


    CTreeDynamic<int> dynamicTreeTest4;

    dynamicTreeTest4.pcGetRoot()->vSetValue(1);

    dynamicTreeTest4.pcGetRoot()->vAddNewChild();
    dynamicTreeTest4.pcGetRoot()->vAddNewChild();
    dynamicTreeTest4.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(2);
    dynamicTreeTest4.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vSetValue(3);

    dynamicTreeTest4.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vAddNewChild();
    dynamicTreeTest4.pcGetRoot()->pcGetChild(1)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(4);

    dynamicTreeTest4.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vAddNewChild();
    dynamicTreeTest4.pcGetRoot()->pcGetChild(0)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(5);



    CTreeDynamic<double> dynamicTreeTest5;

    dynamicTreeTest5.pcGetRoot()->vSetValue(1.9);
    dynamicTreeTest5.pcGetRoot()->vAddNewChild();
    dynamicTreeTest5.pcGetRoot()->vAddNewChild();
    dynamicTreeTest5.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(2.9);
    dynamicTreeTest5.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vSetValue(3.9);
    dynamicTreeTest5.pcGetRoot()->pcGetChild(1)->pcGetRoot()->vAddNewChild();
    dynamicTreeTest5.pcGetRoot()->pcGetChild(1)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(4.9);
    dynamicTreeTest5.pcGetRoot()->pcGetChild(0)->pcGetRoot()->vAddNewChild();
    dynamicTreeTest5.pcGetRoot()->pcGetChild(0)->pcGetRoot()->pcGetChild(0)->pcGetRoot()->vSetValue(5.9);

    cout << "\n" << endl;

    cout << "\n\n\n\n\n" << *dynamicTreeTest4.ptMul() << endl;
    cout << "\n\n\n\n\n" << *dynamicTreeTest5.ptMul() << endl;
    



}


