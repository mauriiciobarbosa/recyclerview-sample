RecyclerView Sample
======================

This project is a sample about the `RecyclerView` API. The goal is serve as a brief introduction to beginners on the android platform.

## Overview

`RecyclerView` is a `ViewGroup` used to render any adapter-based view in a similar way. It was launched in 2014 and is supposed to be the successor of `ListView` and `GridView`. `RecyclerView` has a more extensible framework, especially since it provides the ability to implement both horizontal and vertical layouts. Futhermore, unlike `ListView` and `GridView`, `RecyclerView` is independent from Android SDK, has performance improvements and allows smart animations.

<img src="https://enoent.fr/images/articles/recyclerview-basics/recyclerview-remove.gif" width="32%">

### More Features
* `Viewholders` as the unit of recycling and reuse.
* Separate view creation and binding.
* Use stantard framework focus and input handling.
* Smart adapters that enables more efficient recycling and animations.

## RecyclerView x ListView

`RecyclerView` differs from `ListView` mainly because of the following features:
* **Required ViewHolders in Adapters** - `ListView` adapters doesn't require the use of `ViewHolder`, which is a pattern to improve perfomance. `RecyclerView` brings it as its first class API. You must use `RecyclerView.Viewholder` in order to build your `RecyclerView`.
* **Customizable Item Layouts** - ListView's able only to layout items in a vertical linear arrangement. In contrast, the `RecyclerView` API provides the `RecyclerView.LayoutManager` in order to achieve layouts like horizontal, vertical, grids and staggered grids.
* **Easy Item Animations** - `ListView` contains no special provisions through which one can animate the addition or deletion of items. In contrast, the `RecyclerView` has the `RecyclerView.ItemAnimator` class for handling item animations.
* **Manual Data Source** - `ListView` had adapters for different sources such as `ArrayAdapter` and `CursorAdapter` for arrays and database results respectively. In contrast, the `RecyclerView.Adapter` requires a custom implementation to supply the data to adapter.
* **Manual Item Decoration** - `ListView` has a `AdapterView.OnItemClickListener` interface for binding to the click events for individual items in the list. In contrast, `RecyclerView` only has support for `RecyclerView.OnItemTouchListener` which manages individual touch events but has no built-in click handling.

## RecyclerView API

### Main Components

* **RecyclerView** - The `ViewGroup` that is used on the layout. It receives the others components in order to build itself and change its behavior.
* **RecyclerView.Adapter** - Component that is supposed to provide the views. It creates and binds viewholder, notify `RecyclerView` about dataset changes and provides granular data change events.
* **RecyclerView.Viewholder** - The component which holds the reference for the views part of an list item.
* **RecyclerView.LayoutManager** - Put the views on the right position. It's supposed to handle scroll, bring new items to focus and handle accessibility.

<img src="https://developer.android.com/training/material/images/RecyclerView.png" width="70%">

### Other Components

* **RecyclerView.ItemAnimator** - Helps with animating the items for common operations such as addition or removal of item.
* **RecyclerView.ItemDecorator** - Used to decorate the items.
* **RecyclerView.RecycledViewPool** - Sanctuary for reserve `Viewholders`. May be shared between `RecyclerViews` or custom `ViewGroups`.

## Tips & Tricks

* `No Update == No onBind`. Items aren't rebound unless they are updates.
* To have access to the adapter position from the `Viewholder` use `viewholder.getAdapterPosition()` instead of assume the viewholder's position at `onBind` method.
* Use Payloads to update parts of the view that actually changed.
* Use adapter's position to access your data.
* Use layout's position to get the data from the view that was actually changed.

## References
- [RecyclerView](https://developer.android.com/reference/android/support/v7/widget/RecyclerView)
- [CodePath - Using the RecyclerView](https://guides.codepath.com/android/Using-the-RecyclerView)
- [Create a List with RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
