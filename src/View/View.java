package View;

import Presenter.Presenter;

public interface View {
    void print(String outString);
    void start();
    void setPresenter(Presenter presenter);
}
