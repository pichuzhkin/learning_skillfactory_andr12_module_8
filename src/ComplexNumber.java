class ComplexNumber {
    private final double re, im;

    public ComplexNumber(double real_part, double imaginary_part) {
        this.re = real_part;
        this.im = imaginary_part;
    }

    public boolean isReal() {
        return this.im == 0d;
    }

    public boolean isImaginary() {
        return this.re == 0d && this.im != 0d;
    }


    @Override
    public String toString() {
        if (isReal()) {
            return Double.toString(re);
        } else if (isImaginary()) {
            return Double.toString(im) + "i";
        } else return Double.toString(re) + (im > 0d ? " + ":" ") +Double.toString(im) + "i";
    }
}
