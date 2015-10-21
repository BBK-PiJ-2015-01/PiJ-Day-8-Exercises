public class DoubleLinkedStringList {

    private StringListMember head;

    public void add(String value) {

        if (value == null || value.isEmpty()) {
            return;
        }
        if (head == null) {
            head = new StringListMember(value);
        } else {
            head.add(value);
        }
    }

    public void remove(String value) {

        if (value == null || value.isEmpty()) {
            return;
        }
        if (head == null) {
            return;
        }
        // special condition
        if (value.equals(head.value) || head.getNext() == null) {
            head = null;
        } else {
            head.remove(value);
        }
    }

    public String[] get() {

        if (head == null) {
            return new String[0];
        }
        return head.getValueArray(new ExtensibleStringArray());
    }

    class StringListMember {

        private final String value;
        StringListMember next;
        StringListMember prev;

        public StringListMember(String value) {

            this.value = value;
            next = null;
            prev = null;
        }

        public StringListMember getNext() {
            return next;
        }

        public void setNext(StringListMember next) {
            this.next = next;
        }

        public StringListMember getPrev() {
            return prev;
        }

        public void setPrev(StringListMember prev) {
            this.prev = prev;
        }

        public String getValue() {
            return value;
        }

        public void add(String value) {

            if (value == null || value.isEmpty()) {
                return;
            }

            if (next == null) {
                next = new StringListMember(value);
                next.setPrev(this);
            } else {
                next.add(value);
            }
        }

        public void remove(String value) {

            if (value == null || value.isEmpty()) {
                return;
            }
            if (value.equals(this.value)) {

                if (next != null) {
                    next.setPrev(prev);
                }
                if (prev != null) {
                    prev.setNext(next);
                }
            } else if (next != null) {
                next.remove(value);
            }
        }

        public String[] getValueArray(ExtensibleStringArray array) {

            array.add(value);
            if (next != null) {
                next.getValueArray(array);
            }
            return array.getArray();
        }
    }
}
