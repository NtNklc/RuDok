package rudok.observer;

import rudok.observer.IPublisher;
import rudok.observer.ISubscriber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class APublisher implements IPublisher, Serializable {

    private transient List<ISubscriber> subscribers;
    public APublisher(){

    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if (sub == null) return;
        if(this.subscribers == null) this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub)) return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty()) return;
        for(ISubscriber s: this.subscribers)
            s.update(notification);

    }


    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }


}
