class Computer {
    private String CPU, RAM, Storage;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
    }

    public static class Builder {
        private String CPU, RAM, Storage;

        public Builder setCPU(String c) {
            this.CPU = c;
            return this;
        }

        public Builder setRAM(String r) {
            this.RAM = r;
            return this;
        }

        public Builder setStorage(String s) {
            this.Storage = s;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public void show() {
        System.out.println("CPU: " + CPU + ", RAM: " + RAM + ", Storage: " + Storage);
    }
}

class DesignEx3 {
    public static void main(String[] args) {
        Computer comp = new Computer.Builder().setCPU("i7").setRAM("16GB").setStorage("1TB").build();
        comp.show();
    }
}
