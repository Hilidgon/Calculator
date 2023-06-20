class Array {
    String[] example = null;
    String operandExample = null;
    void setArray(String input) {
        String[] operand = {"+", "-", "/", "*"};
        String[] splitOperand = {"\\+", "-", "/", "\\*"};

        int operandIndex = -1;
        for (int i = 0; i < operand.length; i++) {
            if (input.contains(operand[i])) {
                operandIndex = i;
                break;
            }
        }
        operandExample = operand[operandIndex];
        example = input.split(splitOperand[operandIndex]);
    }
    void setArrayCheck(String input){
        String[] operand = {"+", "-", "/", "*"};
        String[] splitOperand = {"\\+", "-", "/", "\\*"};

        int operandIndex = -1;
        for (int i = 0; i < operand.length; i++) {
            if (input.contains(operand[i])) {
                operandIndex = i;
                break;
            }
        }
        if (operandIndex<0){
            example = new String[1];
            example[0] = input;
        }else {
            operandExample = operand[operandIndex];
            example = input.split(splitOperand[operandIndex]);
        }
    }

    String[] getData (){
        return example;
    }

    String getOperand(){
        return operandExample;
    }

    Boolean checkArray (){
        Converter converter = new Converter();
        int a;
        boolean isRoman = false;
        for (int i = 0; i < example.length; i++) {
            isRoman = converter.isRoman(example[i]);
            if (isRoman) {
                a = converter.romanToInt(example[i]);
            } else {
                a = Integer.parseInt(example[i]);
            }
            if (a>0 && a<11) {}
            else {return false;}
        }
        return true;
    }

}
