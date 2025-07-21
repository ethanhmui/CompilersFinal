/*-------------------------------------------------------------------------*
 *---                                                                   ---*
 *---        ParseNode.java                                             ---*
 *---                                                                   ---*
 *---    This file declares classes that represent parse tree nodes.    ---*
 *---                                                                   ---*
 *---    ----    ----    ----    ----    ----    ----    ----    ----   ---*
 *---                                                                   ---*
 *---    Version 1a        2025 May 31       Joseph Phillips            ---*
 *---                                                                   ---*
 *-------------------------------------------------------------------------*/

import java.util.ArrayList;
import java.util.List;
import java.util.Objects; // For Objects.requireNonNull

public abstract class ParseNode {
    //  I. Constructor(s):
    //  PURPOSE: To initialize 'this'. No parameters. No return value.
    public ParseNode() {
    }

    //  II.  Accessor(s):
    //  PURPOSE: To tell the type that 'this' node returns, or 'NONE' if it
    //	does not return a value.
    public abstract Type getType();

    //  PURPOSE: To return the address of the variable being referenced.
    public Variable getVariable() {
        throw new UnsupportedOperationException("Node has no variable");
    }

    //  III. Mutator(s):
    //  PURPOSE: To set the address of the node on the left to 'node'.
    public void setLeft(ParseNode node) {
        throw new UnsupportedOperationException("Node has no left hand side");
    }

    //  PURPOSE: To set the address of the node on the right to 'node'.
    public void setRight(ParseNode node) {
        throw new UnsupportedOperationException("Node has no right hand side");
    }

    //  PURPOSE: To set the expression whose value should be computed and
    //	written to 'newExpr'.
    public void setExpression(ParseNode newExpr) {
        throw new UnsupportedOperationException("Node has no expression value");
    }

    //  PURPOSE: To set the condition whose value should be computed.
    public void setCondition(ParseNode newCond) {
        throw new UnsupportedOperationException("Node has no condition");
    }

    //  PURPOSE: To set the body whose value should be computed.
    public void setBody(ParseNode newBody) {
        throw new UnsupportedOperationException("Node has no body");
    }

    //  PURPOSE: To set the then whose value should be computed.
    public void setThen(ParseNode newThen) {
        throw new UnsupportedOperationException("Node has no then");
    }

    //  PURPOSE: To set the else whose value should be computed.
    public void setElse(ParseNode newElse) {
        throw new UnsupportedOperationException("Node has no else");
    }

    // PURPOSE: To append newInstruct to the end of the instructions to do.
    public void appendInstruct(ParseNode newInstruct) {
        throw new UnsupportedOperationException("Node has no list of instructions");
    }

    //  PURPOSE: To set the variable.
    public void setVariable(VariableParseNode variable) {
        throw new UnsupportedOperationException("Node has no Variable");
    }

    //  IV. Methods that do main and misc. work of class:
    //  PURPOSE:  To check that '*this' node is semantically proper.  Throws
    //	'const char*' C-string describing problem if one is found.  No return
    //	value.
    public void check()
            throws Exception {
    }

    //  PURPOSE:  To convert '*this' into PotentialInstruction instances in
    //	'list' that implement '*this'.  Returns Variable that will have the
    //	result of '*this' computation, or 'null' if there is no such value.
    public abstract Variable toAssembly(List<PotentialInstruction> list
    )
            throws Exception;

    //  V. Member vars:

}


class BoolParseNode extends ParseNode {
    //  I. Constructor(s):
    //  PURPOSE: To initialize 'this' to represent boolean constant 'newValue'.
    public BoolParseNode(boolean newValue) {
        super();
        this.value_ = newValue;
    }

    //  II.  Accessor(s):
    //  PURPOSE: To return the type that 'this' node returns.
    @Override
    public Type getType() {
        return Type.BOOLEAN;
    }

    //  III. Mutator(s):

    //  IV. Methods that do main and misc. work of class:
    //  PURPOSE:  To convert '*this' into PotentialInstruction instances in
    //	'list' that implement '*this'.  Returns Variable that will have the
    //	result of '*this' computation, or 'null' if there is no such value.
    @Override
    public Variable toAssembly(List<PotentialInstruction> list
    )
            throws Exception {
        return (VarStore.get().obtainTempVar(new BooleanValue(value_)));
    }

    //  V.  Member vars:
    //  PURPOSE: To hold the boolean value.
    private
    boolean value_;

}


class IntParseNode extends ParseNode {
    //  I. Constructor(s):
    //  PURPOSE: To initialize 'this' to represent integer constant 'newValue'.
    public IntParseNode(long newValue) {
        super();
        this.value_ = newValue;
    }


    //  II. Accessor(s):
    //  PURPOSE: To return the type that 'this' node returns.
    @Override
    public Type getType() {
        return Type.INTEGER;
    }

    //  III. Mutator(s):

    //  IV. Methods that do main and misc. work of class:
    //  PURPOSE:  To convert '*this' into PotentialInstruction instances in
    //	'list' that implement '*this'.  Returns Variable that will have the
    //	result of '*this' computation, or 'null' if there is no such value.
    @Override
    public Variable toAssembly(List<PotentialInstruction> list
    )
            throws Exception {
        return (VarStore.get().obtainTempVar(new IntegerValue(value_)));
    }

    //  V. Member vars:
    //  PURPOSE: To hold the integer.
    private
    long value_;

}


class RealParseNode extends ParseNode {
    //  I. Constructor(s):
    //  PURPOSE: To initialize 'this' to represent real constant 'newValue'.
    public RealParseNode(double newValue) {
        super();
        this.value_ = newValue;
    }

    //  II. Accessor(s):
    // PURPOSE: To return the type that 'this' node returns.
    @Override
    public Type getType() {
        return Type.REAL;
    }

    //  III. Mutator(s):

    //  IV. Methods that do main and misc. work of class:
    //  PURPOSE:  To convert '*this' into PotentialInstruction instances in
    //	'list' that implement '*this'.  Returns Variable that will have the
    //	result of '*this' computation, or 'null' if there is no such value.
    @Override
    public Variable toAssembly(List<PotentialInstruction> list
    )
            throws Exception {
        return (VarStore.get().obtainTempVar(new RealValue(value_)));
    }

    //  V.  Member vars:
    //  PURPOSE: To hold the real.
    private
    double value_;

}


class StringParseNode extends ParseNode {
    //  I. Constructor(s):
    //  PURPOSE: To initialize 'this' to represent string constant 'newValue'.
    public StringParseNode(String newValue) {
        super();
        this.value_ = newValue;
    }

    //  II.  Accessor(s):
    // PURPOSE: To return the type that 'this' node returns.
    @Override
    public Type getType() {
        return Type.STRING;
    }

    //  III. Mutator(s):

    //  IV. Methods that do main and misc. work of class:
    //  PURPOSE:  To convert '*this' into PotentialInstruction instances in
    //	'list' that implement '*this'.  Returns Variable that will have the
    //	result of '*this' computation, or 'null' if there is no such value.
    @Override
    public Variable toAssembly(List<PotentialInstruction> list
    )
            throws Exception {
        return (VarStore.get().obtainTempVar(new StringValue(value_)));
    }

    //  V. Member vars:
    //  PURPOSE: To hold the string.
    private
    String value_;

}


class BinaryOpParseNode extends ParseNode {
    //  I. Constructor(s):
    //  PURPOSE: To initialize 'this' with a new operation.
    public BinaryOpParseNode(Operation newOperation,
                             ParseNode newLeft,
                             ParseNode newRight
    ) {
        super();
        this.operation_ = newOperation;
        this.left_ = newLeft;
        this.right_ = newRight;
    }

    //  II. Accessor(s):
    //  PURPOSE: To return the type that 'this' node returns.
    @Override
    public Type getType() {
        switch (getOperation()) {
            case EQUALS:
            case NOT_EQUALS:
            case LESSER:
            case LESSER_EQUALS:
            case GREATER:
            case GREATER_EQUALS:
            case OR:
            case AND:
                return Type.BOOLEAN;

            case MOD:
            case DIV:
                return Type.INTEGER;

            case PLUS:
            case MINUS:
            case STAR:
                if ((getLeft().getType() == Type.INTEGER) &&
                        (getRight().getType() == Type.INTEGER)
                ) {
                    return Type.INTEGER;
                }

            case SLASH:
                return Type.REAL;

            default:
                return Type.NONE;
        }
    }

    //  PURPOSE: To return the operation to do.
    public Operation
    getOperation() {
        return operation_;
    }

    //  PURPOSE: To return the address of node on the left hand side.
    public ParseNode getLeft() {
        return left_;
    }

    //  PURPOSE: To return the address of node on the right hand side.
    public ParseNode getRight() {
        return right_;
    }

    //  III. Mutator(s):
    // PURPOSE: To set the address of the node on the left to 'node'.
    @Override
    public void setLeft(ParseNode node) {
        this.left_ = node;
    }

    // PURPOSE: To set the address of the node on the right to 'node'.
    @Override
    public void setRight(ParseNode node) {
        this.right_ = node;
    }

    //  IV. Methods that do main and misc. work of class:
    //  PURPOSE:  To check that '*this' node is semantically proper.  Throws
    //	'const char*' C-string describing problem if one is found.  No return
    //	value.
    @Override
    public void check()
            throws Exception {
        getLeft().check();
        getRight().check();

        switch (getOperation()) {
            case EQUALS:
            case NOT_EQUALS:
            case LESSER:
            case LESSER_EQUALS:
            case GREATER:
            case GREATER_EQUALS:
                if (getLeft().getType() != getRight().getType()) {
                    if (((getLeft().getType() != Type.INTEGER) &&
                            (getLeft().getType() != Type.REAL)
                    ) ||
                            ((getRight().getType() != Type.INTEGER) &&
                                    (getRight().getType() != Type.REAL)
                            )
                    ) {
                        throw new Exception("Comparisons require compatible operands");
                    }
                }
                break;

            case PLUS:
            case MINUS:
            case STAR:
            case SLASH:
                if (((getLeft().getType() != Type.INTEGER) &&
                        (getLeft().getType() != Type.REAL)
                ) ||
                        ((getRight().getType() != Type.INTEGER) &&
                                (getRight().getType() != Type.REAL)
                        )
                ) {
                    throw new Exception("+,-,*,/ require numeric operands");
                }
                break;

            case DIV:
            case MOD:
                if ((getLeft().getType() != Type.INTEGER) ||
                        (getRight().getType() != Type.INTEGER)
                ) {
                    throw new Exception("DIV and MOD require integer operands");
                }
                break;

            case AND:
            case OR:
                if ((getLeft().getType() != Type.BOOLEAN) ||
                        (getRight().getType() != Type.BOOLEAN)
                ) {
                    throw new Exception("Boolean operators require boolean operands");
                }
                break;
        }
    }

    //  PURPOSE:  To convert '*this' into PotentialInstruction instances in
    //	'list' that implement '*this'.  Returns Variable that will have the
    //	result of '*this' computation, or 'null' if there is no such value.
    @Override
    public Variable toAssembly(List<PotentialInstruction> list
    )
            throws Exception {
        Type operandType;
        Variable leftConvert;
        Variable rightConvert;
        Variable result = VarStore.get().obtainTempVar(getType());
        Variable leftVar = getLeft().toAssembly(list);
        Variable rightVar = getRight().toAssembly(list);
        VmOperation vmOp = VmOperation.NO_VM_OP;

        switch (getOperation()) {
            case EQUALS:
            case NOT_EQUALS:
            case LESSER:
            case LESSER_EQUALS:
            case GREATER:
            case GREATER_EQUALS:
                operandType = getLeft().getType();

                if (getLeft().getType() == Type.INTEGER) {
                    if (getRight().getType() == Type.INTEGER) {
                        operandType = Type.INTEGER;
                    } else if (getRight().getType() == Type.REAL) {
                        operandType = Type.REAL;
                        leftConvert = VarStore.get().obtainTempVar(Type.REAL);
                        list.add
                                (new VarVarPotentialInstruction
                                        (VmOperation.INT_TO_REAL_VM_OP,
                                                leftConvert,
                                                leftVar
                                        )
                                );
                        leftVar = leftConvert;
                    }
                } else if (getLeft().getType() == Type.REAL) {
                    if (getRight().getType() == Type.INTEGER) {
                        operandType = Type.REAL;
                        rightConvert = VarStore.get().obtainTempVar(Type.REAL);
                        list.add
                                (new VarVarPotentialInstruction
                                        (VmOperation.INT_TO_REAL_VM_OP,
                                                rightConvert,
                                                rightVar
                                        )
                                );
                        rightVar = rightConvert;
                    } else if (getRight().getType() == Type.REAL) {
                        operandType = Type.REAL;
                    }
                }

                switch (getOperation()) {
                    case EQUALS:
                        vmOp = (operandType == Type.INTEGER)
                                ? VmOperation.INT_EQUAL_VM_OP : VmOperation.REAL_EQUAL_VM_OP;
                        break;
                    case NOT_EQUALS:
                        vmOp = (operandType == Type.INTEGER)
                                ? VmOperation.INT_NOT_EQUAL_VM_OP
                                : VmOperation.REAL_NOT_EQUAL_VM_OP;
                        break;
                    case LESSER:
                        vmOp = (operandType == Type.INTEGER)
                                ? VmOperation.INT_LESSER_VM_OP
                                : VmOperation.REAL_LESSER_VM_OP;
                        break;
                    case LESSER_EQUALS:
                        vmOp = (operandType == Type.INTEGER)
                                ? VmOperation.INT_LESSER_EQUAL_VM_OP
                                : VmOperation.REAL_LESSER_EQUAL_VM_OP;
                        break;
                    case GREATER:
                        vmOp = (operandType == Type.INTEGER)
                                ? VmOperation.INT_GREATER_VM_OP
                                : VmOperation.REAL_GREATER_VM_OP;
                        break;
                    case GREATER_EQUALS:
                        vmOp = (operandType == Type.INTEGER)
                                ? VmOperation.INT_GREATER_EQUAL_VM_OP
                                : VmOperation.REAL_GREATER_EQUAL_VM_OP;
                        break;
                }

                list.add
                        (new VarVarVarPotentialInstruction
                                (vmOp,
                                        result,
                                        leftVar,
                                        rightVar
                                )
                        );
                break;

            case SLASH:
                if (getLeft().getType() == Type.INTEGER) {
                    leftConvert = VarStore.get().obtainTempVar(Type.REAL);
                    list.add
                            (new VarVarPotentialInstruction
                                    (VmOperation.INT_TO_REAL_VM_OP,
                                            leftConvert,
                                            leftVar
                                    )
                            );
                    leftVar = leftConvert;
                }

                if (getRight().getType() == Type.INTEGER) {
                    rightConvert = VarStore.get().obtainTempVar(Type.REAL);
                    list.add
                            (new VarVarPotentialInstruction
                                    (VmOperation.INT_TO_REAL_VM_OP,
                                            rightConvert,
                                            rightVar
                                    )
                            );
                    rightVar = rightConvert;
                }

                list.add
                        (new VarVarVarPotentialInstruction
                                (VmOperation.REAL_DIV_VM_OP,
                                        result,
                                        leftVar,
                                        rightVar
                                )
                        );
                break;

            case DIV:
            case MOD:
                list.add
                        (new VarVarVarPotentialInstruction
                                ((getOperation() == Operation.DIV)
                                        ? VmOperation.INT_DIV_VM_OP
                                        : VmOperation.MOD_VM_OP,
                                        result,
                                        leftVar,
                                        rightVar
                                )
                        );
                break;

            case AND:
            case OR:
                list.add
                        (new VarVarVarPotentialInstruction
                                ((getOperation() == Operation.AND)
                                        ? VmOperation.LOGIC_AND_VM_OP
                                        : VmOperation.LOGIC_OR_VM_OP,
                                        result,
                                        leftVar,
                                        rightVar
                                )
                        );
                break;

            case PLUS:
            case MINUS:
            case STAR:
                operandType = leftVar.getType();

                if (leftVar.getType() == Type.INTEGER) {
                    if (rightVar.getType() == Type.INTEGER) {
                        operandType = Type.INTEGER;
                    } else if (rightVar.getType() == Type.REAL) {
                        operandType = Type.REAL;
                        leftConvert = VarStore.get().obtainTempVar(Type.REAL);
                        list.add
                                (new VarVarPotentialInstruction
                                        (VmOperation.INT_TO_REAL_VM_OP,
                                                leftConvert,
                                                leftVar
                                        )
                                );
                        leftVar = leftConvert;
                    }
                } else if (leftVar.getType() == Type.REAL) {
                    if (rightVar.getType() == Type.INTEGER) {
                        operandType = Type.REAL;
                        rightConvert = VarStore.get().obtainTempVar(Type.REAL);
                        list.add
                                (new VarVarPotentialInstruction
                                        (VmOperation.INT_TO_REAL_VM_OP,
                                                rightConvert,
                                                rightVar
                                        )
                                );
                        rightVar = rightConvert;
                    } else if (rightVar.getType() == Type.REAL) {
                        operandType = Type.REAL;
                    }
                }

                switch (getOperation()) {
                    case PLUS:
                        vmOp = (getType() == Type.INTEGER)
                                ? VmOperation.INT_ADD_VAR_VAR_VM_OP
                                : VmOperation.REAL_ADD_VAR_VAR_VM_OP;
                        break;
                    case MINUS:
                        vmOp = (getType() == Type.INTEGER)
                                ? VmOperation.INT_SUB_VAR_VAR_VM_OP
                                : VmOperation.REAL_SUB_VAR_VAR_VM_OP;
                        break;
                    case STAR:
                        vmOp = (getType() == Type.INTEGER)
                                ? VmOperation.INT_MUL_VAR_VAR_VM_OP
                                : VmOperation.REAL_MUL_VAR_VAR_VM_OP;
                        break;

                    default:
                        throw new Exception
                                ("Non-handled op case in BinaryOpParseNode::toAssembly()");
                }

                list.add
                        (new VarVarPotentialInstruction
                                ((getType() == Type.INTEGER)
                                        ? VmOperation.INT_COPY_VM_OP
                                        : VmOperation.REAL_COPY_VM_OP,
                                        result,
                                        leftVar
                                )
                        );
                list.add(new VarVarPotentialInstruction(vmOp, result, rightVar));
                break;
        }

        return (result);
    }

    //  V.  Member vars:
    //  PURPOSE: To tell the operation to do.
    private
    Operation operation_;

    //  PURPOSE: To hold the address of node on the left hand side.
    private
    ParseNode left_;

    //  PURPOSE: To hold the address of node on the right hand side.
    private
    ParseNode right_;

}


class WriteParseNode extends ParseNode {
    //  I. Constructor(s), factory(s), assignment op(s), destructor:
    //  PURPOSE: To initialize 'this'.
    public WriteParseNode(boolean newShouldPrintNewline,
                          ParseNode newExpression
    ) {
        super();
        this.shouldWriteNewline_ = newShouldPrintNewline;
        this.expression_ = newExpression;
    }


    //  II. Accessor(s):
    // PURPOSE: To return the type that 'this' node returns.
    @Override
    public Type getType() {
        return Type.NONE;
    }

    // PURPOSE: To return 'true' if 'this' node should print a newline after
    //	printing its expression value, or 'false' otherwise.
    public boolean getShouldWriteNewline
    () {
        return shouldWriteNewline_;
    }

    //  III. Mutator(s):
    // PURPOSE: To set the expression whose value should be computed and
    //	written to 'newExpr'.
    @Override
    public void setExpression(ParseNode newExpr) {
        this.expression_ = newExpr;
    }

    //  IV. Methods that do main and misc. work of class:
    //  PURPOSE:  To check that '*this' node is semantically proper.  Throws
    //	'const char*' C-string describing problem if one is found.  No return
    //	value.
    @Override
    public void check()
            throws Exception {
        this.expression_.check();

        //  YOUR CODE HERE
    }

    //  PURPOSE:  To convert '*this' into PotentialInstruction instances in
    //	'list' that implement '*this'.  Returns Variable that will have the
    //	result of '*this' computation, or 'null' if there is no such value.
    @Override
    public Variable toAssembly(List<PotentialInstruction> list
    )
            throws Exception {
        //  YOUR CODE HERE
        VmOperation op = this.shouldWriteNewline_?VmOperation.STDOUT_PRINTLN_VM_OP:VmOperation.STDOUT_PRINT_VM_OP;
        list.add(new VarPotentialInstruction(op,this.expression_.toAssembly(list)));
        return (null);
    }

    //  V. Member vars:
    //  PURPOSE: To hold 'true' if 'this' node should print a newline after
    //	printing its expression value, or 'false' otherwise.
    private
    boolean shouldWriteNewline_;

    //  PURPOSE: To hold the expression whose value should be computed and
    //	written.
    private
    ParseNode expression_;

}


class VariableParseNode extends ParseNode {
    //  I. Constructor(s):
    //  PURPOSE: To initialize 'this'.
    public VariableParseNode(Variable newVar) {
        super();
        this.variable_ = newVar;
    }

    //  II. Accessor(s):
    // PURPOSE: To return the type that 'this' node returns.
    @Override
    public Type getType() {
        return Objects.requireNonNull(getVariable()).getType();
    }

    //  PURPOSE: To return the address of the variable being referenced.
    @Override
    public Variable getVariable() {
        return variable_;
    }

    //  III. Mutator(s):
    //  PURPOSE: To set the type of 'this' variable to 'type'.
    public void setType(Type type) {
        Objects.requireNonNull(variable_).setType(type);
    }

    public void setValue(Value newValue
    ) {
        variable_.setValue(newValue);
    }

    //  IV. Methods that do the main and misc. work of class:
    //	result of '*this' computation, or 'null' if there is no such value.
    @Override
    public Variable toAssembly(List<PotentialInstruction> list
    )
            throws Exception {
        return (getVariable());
    }

    //  V.  Member vars:
    //  PURPOSE: To hold the address of the variable being referenced.
    private
    Variable variable_;

}


class AssignParseNode extends ParseNode {
    //  I.  Constructor(s):
    //  PURPOSE:  To initialize 'this'.
    public AssignParseNode(VariableParseNode newVarParse,
                           ParseNode newExpr
    ) {
        super();
        this.varNode_ = newVarParse;
        this.expr_ = newExpr;
    }


    //  II. Accessor(s):
    //  PURPOSE: To return the type that 'this' node returns.
    @Override
    public Type getType() {
        return Type.NONE;
    }

    //  III. Mutator(s):
    // PURPOSE: To set the body whose value should be computed.
    @Override
    public void setBody(ParseNode newBody) {
        this.expr_ = newBody;
    }

    //  PURPOSE: To set the expression whose value should be computed and
    //	written to 'newExpr'.
    @Override
    public void setExpression(ParseNode newExpr) {
        this.expr_ = newExpr;
    }

    //  PURPOSE: To set the variable to 'variable'.
    @Override
    public void setVariable(VariableParseNode variable) {
        this.varNode_ = variable;
    }

    //  IV. Methods that do the main and misc. work of class:
    //  PURPOSE:  To check that '*this' node is semantically proper.  Throws
    //	'const char*' C-string describing problem if one is found.  No return
    //	value.
    @Override
    public void check()
            throws Exception {
        this.expr_.check();
        if(!this.expr_.getType().equals(this.varNode_.getType()))
            throw new Exception("Assign variable requires matching type expression");
        //  YOUR CODE HERE
    }

    //  PURPOSE:  To convert '*this' into PotentialInstruction instances in
    //	'list' that implement '*this'.  Returns Variable that will have the
    //	result of '*this' computation, or 'null' if there is no such value.
    @Override
    public Variable toAssembly(List<PotentialInstruction> list
    )
            throws Exception {
        //  YOUR CODE HERE
        if(this.expr_.getType().equals(Type.INTEGER)) {
            list.add(new VarVarPotentialInstruction(VmOperation.INT_COPY_VM_OP,this.varNode_.toAssembly(list),this.expr_.toAssembly(list)));
        }
        else if(this.expr_.getType().equals(Type.REAL)) {
            list.add(new VarVarPotentialInstruction(VmOperation.REAL_COPY_VM_OP,this.varNode_.toAssembly(list),this.expr_.toAssembly(list)));

        }
        else{
            list.add(new VarVarPotentialInstruction(VmOperation.IDEA_COPY_VM_OP,this.varNode_.toAssembly(list),this.expr_.toAssembly(list)));
        }
        //  YOUR CODE HERE
        return (null);
    }

    //  V.  Member vars:
    //  PURPOSE: To hold the address of the variable node.
    private
    VariableParseNode varNode_;

    //  PURPOSE: To hold the address of the expression.
    private
    ParseNode expr_;

}


class IfParseNode extends ParseNode {
    //  I. Constructor(s):
    //  PURPOSE: To initialize 'this'.
    public IfParseNode(ParseNode newCond,
                       ParseNode newThen
    ) {
        this(newCond, newThen, null);
    }

    public IfParseNode(ParseNode newCond,
                       ParseNode newThen,
                       ParseNode newElse
    ) {
        super();
        this.cond_ = newCond;
        this.then_ = newThen;
        this.else_ = newElse;
    }

    //  III. Accessor(s):
    //  PURPOSE: To return the type that 'this' node returns.
    @Override
    public Type getType() {
        return Type.NONE;
    }

    //  IV. Mutator(s):
    // PURPOSE: To set the expression whose value should be computed and
    //	written to 'newExpr'.
    @Override
    public void setExpression(ParseNode newExpr) {
        this.cond_ = newExpr;
    }

    // PURPOSE: To set the condition whose value should be computed.
    @Override
    public void setCondition(ParseNode newCond) {
        this.cond_ = newCond;
    }

    // PURPOSE: To set the body whose value should be computed.
    @Override
    public void setBody(ParseNode newBody) {
        this.then_ = newBody;
    }

    // PURPOSE: To set the then whose value should be computed.
    @Override
    public void setThen(ParseNode newThen) {
        this.then_ = newThen;
    }

    // PURPOSE: To set the else whose value should be computed.
    @Override
    public void setElse(ParseNode newElse) {
        this.else_ = newElse;
    }

    //  IV. Methods that do the main and misc. work of class:
    //  PURPOSE:  To check that '*this' node is semantically proper.  Throws
    //	'const char*' C-string describing problem if one is found.  No return
    //	value.
    @Override
    public void check()
            throws Exception {
        this.cond_.check();
        if(this.else_!=null)
            this.else_.check();
        this.then_.check();
        if(!this.cond_.getType().equals(Type.BOOLEAN))
            throw new Exception("If condition requires boolean expression");

        //  YOUR CODE HERE
    }


    //  PURPOSE:  To convert '*this' into PotentialInstruction instances in
    //	'list' that implement '*this'.  Returns Variable that will have the
    //	result of '*this' computation, or 'null' if there is no such value.
    @Override
    public Variable toAssembly(List<PotentialInstruction> list
    )
            throws Exception {
        //  YOUR CODE HERE
        if(this.else_!=null) {
            long toElse = PotentialInstruction.getNextAddressLabel();

            long toEnd = PotentialInstruction.getNextAddressLabel();

            list.add(new VarAddrPotentialInstruction(VmOperation.IF_FALSE_GOTO_VM_OP, this.cond_.toAssembly(list), toElse));
            this.then_.toAssembly(list);

            list.add(new VarAddrPotentialInstruction(VmOperation.IF_TRUE_GOTO_VM_OP, this.cond_.toAssembly(list), toEnd));

            PotentialInstruction instruct = new PotentialInstruction(VmOperation.NO_VM_OP);
            instruct.setAddressLabel(toElse);
            list.add(instruct);

            this.else_.toAssembly(list);

            PotentialInstruction instruct2 = new PotentialInstruction(VmOperation.NO_VM_OP);
            instruct2.setAddressLabel(toEnd);
            list.add(instruct2);
        }else{
            long toEnd = PotentialInstruction.getNextAddressLabel();

            list.add(new VarAddrPotentialInstruction(VmOperation.IF_FALSE_GOTO_VM_OP, this.cond_.toAssembly(list), toEnd));
            this.then_.toAssembly(list);

            PotentialInstruction instruct = new PotentialInstruction(VmOperation.NO_VM_OP);
            instruct.setAddressLabel(toEnd);
            list.add(instruct);
        }

        return (null);
    }

    //  V. Member vars:
    //  PURPOSE: To hold the address of the condition.
    private
    ParseNode cond_;

    //  PURPOSE: To hold the address of the then (body).
    private
    ParseNode then_;

    //  PURPOSE: To hold the address of the else.
    private
    ParseNode else_;

}


class WhileDoParseNode extends ParseNode {
    //  I. Constructor(s):
    //  PURPOSE: To initialize 'this'.
    public WhileDoParseNode(ParseNode newCond,
                            ParseNode newBody
    ) {
        super();
        this.cond_ = newCond;
        this.body_ = newBody;
    }

    //  II. Accessor(s):
    //  PURPOSE: To return the type that 'this' node returns.
    @Override
    public Type getType() {
        return Type.NONE;
    }

    //  III. Mutator(s):
    //  PURPOSE: To set the expression whose value should be computed and
    //	written to 'newExpr'.
    @Override
    public void setExpression(ParseNode newExpr) {
        this.cond_ = newExpr;
    }

    //  PURPOSE: To set the condition whose value should be computed.
    @Override
    public void setCondition(ParseNode newCond) {
        this.cond_ = newCond;
    }

    //  PURPOSE: To set the body whose value should be computed.
    @Override
    public void setBody(ParseNode newBody) {
        this.body_ = newBody;
    }

    //  IV. Methods that do the main and misc. work of class:
    //  PURPOSE:  To check that '*this' node is semantically proper.  Throws
    //	'const char*' C-string describing problem if one is found.  No return
    //	value.
    @Override
    public void check()
            throws Exception {
        this.cond_.check();
        this.body_.check();
        if(!this.cond_.getType().equals(Type.BOOLEAN))
            throw new Exception("While-do condition requires boolean expression");
        //  YOUR CODE HERE
    }


    //  PURPOSE:  To convert '*this' into PotentialInstruction instances in
    //	'list' that implement '*this'.  Returns Variable that will have the
    //	result of '*this' computation, or 'null' if there is no such value.
    @Override
    public Variable toAssembly(List<PotentialInstruction> list
    )
            throws Exception {
        //  YOUR CODE HERE
        long toStart = PotentialInstruction.getNextAddressLabel();
        long toEnd = PotentialInstruction.getNextAddressLabel();


        PotentialInstruction instruct = new PotentialInstruction(VmOperation.NO_VM_OP);
        instruct.setAddressLabel(toStart);
        list.add(instruct);

        list.add(new VarAddrPotentialInstruction(VmOperation.IF_FALSE_GOTO_VM_OP,this.cond_.toAssembly(list),toEnd));

        this.body_.toAssembly(list);

        list.add(new AddrPotentialInstruction(VmOperation.GOTO_VM_OP,toStart));

        PotentialInstruction instruct2 = new PotentialInstruction(VmOperation.NO_VM_OP);
        instruct2.setAddressLabel(toEnd);
        list.add(instruct2);
        return (null);
    }

    //  V.  Member vars:
    //  PURPOSE: To hold the address of the condition.
    private
    ParseNode cond_;

    //  PURPOSE: To hold the address of the body.
    private
    ParseNode body_;

}


class RepeatUntilParseNode extends ParseNode {
    //  I.  Constructor(s):
    //  PURPOSE: To initialize 'this'.
    public RepeatUntilParseNode(ParseNode newBody,
                                ParseNode newCond
    ) {
        super();
        this.body_ = newBody;
        this.cond_ = newCond;
    }

    //  II. Accessor(s):
    //  PURPOSE: To return the type that 'this' node returns.
    @Override
    public Type getType() {
        return Type.NONE;
    }

    //  III. Mutator(s):
    //  PURPOSE: To set the body whose value should be computed.
    @Override
    public void setBody(ParseNode newBody) {
        this.body_ = newBody;
    }

    // PURPOSE: To set the expression whose value should be computed and
    //	written to 'newExpr'.
    @Override
    public void setExpression(ParseNode newExpr) {
        this.cond_ = newExpr;
    }

    // PURPOSE: To set the condition whose value should be computed.
    @Override
    public void setCondition(ParseNode newCond) {
        this.cond_ = newCond;
    }

    //  IV. Methods that do the main and misc. work of class:
    //  PURPOSE:  To check that '*this' node is semantically proper.  Throws
    //	'const char*' C-string describing problem if one is found.  No return
    //	value.
    @Override
    public void check()
            throws Exception {
        //  YOUR CODE HERE
        this.cond_.check();
        this.body_.check();
        if(!this.cond_.getType().equals(Type.BOOLEAN))
            throw new Exception("Repeat-until condition requires boolean expression");

    }

    //  PURPOSE:  To convert '*this' into PotentialInstruction instances in
    //	'list' that implement '*this'.  Returns Variable that will have the
    //	result of '*this' computation, or 'null' if there is no such value.
    @Override
    public Variable toAssembly(List<PotentialInstruction> list
    )
            throws Exception {
        //  YOUR CODE HERE
        long toStart = PotentialInstruction.getNextAddressLabel();

        PotentialInstruction instruct = new PotentialInstruction(VmOperation.NO_VM_OP);
        instruct.setAddressLabel(toStart);
        list.add(instruct);

        this.body_.toAssembly(list);

        list.add(new VarAddrPotentialInstruction(VmOperation.IF_FALSE_GOTO_VM_OP,this.cond_.toAssembly(list),toStart));
        return (null);
    }

    //  V. Member vars:
    //  PURPOSE: To hold the address of the body.
    private
    ParseNode body_;

    //  PURPOSE: To hold the address of the condition.
    private
    ParseNode cond_;

}


class ForParseNode extends ParseNode {
    //  I. Constructor(s):
    //  PURPOSE: To initialize 'this'.
    public ForParseNode(VariableParseNode newVar,
                        ParseNode newInit,
                        ParseNode newFinal,
                        ParseNode newBody,
                        Direction newDirection
    ) {
        super();
        this.var_ = newVar;
        this.initVal_ = newInit;
        this.finalVal_ = newFinal;
        this.body_ = newBody;
        this.direction_ = newDirection;
    }

    //  II. Accessor(s):
    //  PURPOSE: To return the type that 'this' node returns.
    @Override
    public Type getType() {
        return Type.NONE;
    }

    //  III. Mutator(s):
    // PURPOSE: To set the address of the variable.
    public void setVar(VariableParseNode newVar) {
        this.var_ = newVar;
    }

    //  PURPOSE: To set the initial value.
    public void setInitVal(ParseNode value) {
        this.initVal_ = value;
    }

    // PURPOSE: To hold the final value.
    public void setFinalVal(ParseNode value) {
        this.finalVal_ = value;
    }

    //  PURPOSE: To set the body whose value should be computed.
    @Override
    public void setBody(ParseNode newBody) {
        this.body_ = newBody;
    }

    //  IV. Methods that do the main and misc. work of class:
    //  PURPOSE:  To check that '*this' node is semantically proper.  Throws
    //	'const char*' C-string describing problem if one is found.  No return
    //	value.
    @Override
    public void check()
            throws Exception {
        //  YOUR CODE HERE
        this.initVal_.check();
        this.finalVal_.check();
        this.body_.check();
        if(!var_.getType().equals(Type.INTEGER))
            throw new Exception("For variable requires integer expression");

        if(!initVal_.getType().equals(Type.INTEGER))
            throw new Exception("For initial value requires integer expression");

        if(!finalVal_.getType().equals(Type.INTEGER))
            throw new Exception("For final value requires integer expression");

    }

    //  PURPOSE:  To convert '*this' into PotentialInstruction instances in
    //	'list' that implement '*this'.  Returns Variable that will have the
    //	result of '*this' computation, or 'null' if there is no such value.
    @Override
    public Variable toAssembly(List<PotentialInstruction> list
    )
            throws Exception {
        //  YOUR CODE HERE
        long toStart = PotentialInstruction.getNextAddressLabel();
        long toEnd = PotentialInstruction.getNextAddressLabel();

        Variable i = this.var_.toAssembly(list);
        Variable initial = this.initVal_.toAssembly(list);
        Variable inc = this.direction_ == Direction.UP? VarStore.get().obtainTempVar(new IntegerValue(1)) : VarStore.get().obtainTempVar(new IntegerValue(-1));
        list.add(new VarVarPotentialInstruction(VmOperation.INT_COPY_VM_OP,i,initial));

        PotentialInstruction instruct = new PotentialInstruction(VmOperation.NO_VM_OP);
        instruct.setAddressLabel(toStart);
        list.add(instruct);

        ParseNode loopCond = this.direction_ == Direction.UP? new BinaryOpParseNode(Operation.LESSER_EQUALS, this.var_, this.finalVal_):new BinaryOpParseNode(Operation.LESSER, this.finalVal_ , this.var_);;


        list.add(new VarAddrPotentialInstruction(VmOperation.IF_FALSE_GOTO_VM_OP,loopCond.toAssembly(list),toEnd));

        this.body_.toAssembly(list);
        list.add(new VarVarPotentialInstruction(VmOperation.INT_ADD_VAR_VAR_VM_OP,i,inc));

        list.add(new AddrPotentialInstruction(VmOperation.GOTO_VM_OP,toStart));
        PotentialInstruction instruct2 = new PotentialInstruction(VmOperation.NO_VM_OP);
        instruct2.setAddressLabel(toEnd);
        list.add(instruct2);
        return (null);
    }

    //  V.  Member vars:
    //  PURPOSE: To hold the address of the variable.
    private
    VariableParseNode var_;

    //  PURPOSE: To hold the initial value.
    private
    ParseNode initVal_;

    //  PURPOSE: To hold the final value.
    private
    ParseNode finalVal_;

    //  PURPOSE: To hold the address of the body.
    private
    ParseNode body_;

    //  PURPOSE: To hold the direction of counting.
    private
    Direction direction_;

}


class BeginListParseNode extends ParseNode {
    //  I. Constructor(s):
    //  PURPOSE: To initialize 'this'.
    public BeginListParseNode() {
        super();
        this.dataStruct_ = new ArrayList<>();
    }

    //  II. Accessor(s):
    //  PURPOSE: To return the type that 'this' node returns.
    @Override
    public Type getType() {
        return Type.NONE;
    }

    //  III. Mutator(s):
    //  PURPOSE: To append newInstruct to the end of the instructions to do.
    @Override
    public void appendInstruct(ParseNode newInstruct) {
        dataStruct_.add(newInstruct);
    }

    //  IV. Methods that do the main and misc. work of class:
    //  PURPOSE:  To check that '*this' node is semantically proper.  Throws
    //	'const char*' C-string describing problem if one is found.  No return
    //	value.
    @Override
    public void check()
            throws Exception {
        //  YOUR CODE HERE
        for(ParseNode i: this.dataStruct_)
            i.check();
    }

    //  PURPOSE:  To convert '*this' into PotentialInstruction instances in
    //	'list' that implement '*this'.  Returns Variable that will have the
    //	result of '*this' computation, or 'null' if there is no such value.
    @Override
    public Variable toAssembly(List<PotentialInstruction> list
    )
            throws Exception {
        //  YOUR CODE HERE
        for(ParseNode i:this.dataStruct_)
            i.toAssembly(list);
        return (null);
    }

    //  V. Member vars:
    //  PURPOSE: To hold the addresses of the code to run.
    private
    List<ParseNode> dataStruct_;

}
